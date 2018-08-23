package com.spring.ioc;

import com.spring.ioc.aware.Aware;
import com.spring.ioc.aware.BeanFactoryAware;
import com.spring.ioc.aware.BeanNameAware;
import com.spring.ioc.bean.DisposableBean;
import com.spring.ioc.bean.InitializingBean;
import com.spring.ioc.context.BeanFactory;
import com.spring.ioc.processor.BeanPostProcessor;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public class ClassPathXmlApplicationContext implements BeanFactory {
    // 存储管理的beans
    private Map<String, Bean> beans = new HashMap<String, Bean>();

    public ClassPathXmlApplicationContext() throws Exception {
        this("beans.xml");
    }

    /**
     * 通过xml配置来构造IOC容器
     *
     * @param xmlPath xml配置地址
     */
    public ClassPathXmlApplicationContext(String xmlPath) throws Exception {
        System.out.println("start context...");
        // 读取配置节点列表 read xml file
        List<Element> elements = readXmlFileConfig(xmlPath);
        for (Element element : elements) {
            Bean bean = initBeanFromXmlElement(element);
            // 加入
            beans.put(bean.getId(), bean);
        }
    }

    /**
     * 获取bean的配置信息
     *
     * @param xmlPath 配置文件路径
     * @return 配置节点列表
     */
    private List<Element> readXmlFileConfig(String xmlPath) throws Exception {
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(this.getClass().getClassLoader().getResource(xmlPath));
        Element root = document.getRootElement();
        return root.getChildren("bean");
    }

    /**
     * 通过xml配置实例化一个Bean
     *
     * @param element
     * @return
     */
    private Bean initBeanFromXmlElement(Element element) throws Exception {
        // 实例化 constructor
        Bean bean = instanceBean(element);
        // 依赖注入 setter
        injectionSetter(bean);
        // 资源注入 Aware
        injectionAware(bean);
        // 预初始化 BeanPostProcessor.postProcessBeforeInitialization()
        processBeforeInitialization(bean, beans);
        // 初始化 InitializingBean.afterPropertiesSet()
        initializing(bean);
        // 定制初始化 init-method
        customInit(bean);
        // 后初始化 BeanPostProcessor.postProcessAfterInitialization()
        processAfterInitialization(bean, beans);
        // 返回
        return bean;
    }


    /**
     * 实例化一个配置节点
     *
     * @param element 配置节点
     * @return 实例化之后的对象
     */
    private Bean instanceBean(Element element) throws Exception {
        String id = element.getAttributeValue("id");
        String clazz = element.getAttributeValue("class");
        if (id == null) {

        }
        Object instance = null;
        // 取构造参数
        List<Element> constructorArgElements = element.getChildren("constructor-arg");
        // 有参构造
        if (constructorArgElements.size() > 0) {
            Constructor<?> cons[] = Class.forName(clazz).getConstructors();
            Object[] constructorArgs = new Object[constructorArgElements.size()];
            for (int i = 0; i < constructorArgElements.size(); i++) {
                Element constructorArgElement = constructorArgElements.get(i);
                String indexStr = constructorArgElement.getAttributeValue("index");
                String value = constructorArgElement.getAttributeValue("value");
                constructorArgs[indexStr == null ? i : Integer.parseInt(indexStr)] = value;
            }
            for (Constructor<?> con : cons) {
                if (con.getParameterCount() == constructorArgs.length) {
                    instance = con.newInstance(constructorArgs);
                    break;
                }
            }
        }
        // 无参构造
        if (instance == null) {
            instance = Class.forName(clazz).newInstance();
        }
        Bean bean = new Bean();
        bean.setConfig(element);
        bean.setId(id);
        bean.setInstance(instance);
        return bean;
    }

    /**
     * 依赖注入
     *
     * @param bean bean对象
     */
    private void injectionSetter(Bean bean) throws Exception {
        Object instance = bean.getInstance();
        for (Element propertyElement : bean.getConfig().getChildren("property")) {
            String name = propertyElement.getAttributeValue("name");
            Element beanChildElement = propertyElement.getChild("bean");
            Object propertyObj = null;
            if (beanChildElement == null) {
                String value = propertyElement.getAttributeValue("value");
                if (value != null) {
                    propertyObj = value;
                } else {
                    value = propertyElement.getAttributeValue("bean");
                    propertyObj = getBean(value);
                }
            } else {
                Bean childBean = instanceBean(beanChildElement);
                propertyObj = childBean.getInstance();
            }
            // 拼接setter方法
            // 如果参数为userMapper则对应方法的名称默认为setUserMapper
            String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
            // 调用方法完成注入
            Method m = instance.getClass().getDeclaredMethod(methodName, propertyObj.getClass());
            m.invoke(instance, propertyObj);
        }
    }

    /**
     * 注入资源
     *
     * @param bean
     */
    private void injectionAware(Bean bean) {
        Object instance = bean.getInstance();
        if (instance instanceof Aware) {
            if (instance instanceof BeanNameAware) {
                ((BeanNameAware) instance).setBeanName(bean.getId());
            }
            if (instance instanceof BeanFactoryAware) {
                ((BeanFactoryAware) instance).setBeanFactory(this);
            }
        }
    }

    /**
     * 预初始化
     *
     * @param beans
     */
    private void processBeforeInitialization(Bean bean, Map<String, Bean> beans) throws Exception {
        Object instance = bean.getInstance();
        String beanName = bean.getId();
        for (Map.Entry<String, Bean> entry : beans.entrySet()) {
            Object process = entry.getValue().getInstance();
            if (process instanceof BeanPostProcessor) {
                Object ret = ((BeanPostProcessor) process).postProcessBeforeInitialization(instance, beanName);
                bean.setInstance(ret);
            }
        }
    }

    /**
     * 初始化
     *
     * @param bean
     */
    private void initializing(Bean bean) {
        Object instance = bean.getInstance();
        if (instance instanceof InitializingBean) {
            ((InitializingBean) instance).afterPropertiesSet();
        }
    }

    /**
     * 定制初始化
     *
     * @param bean
     */
    private void customInit(Bean bean) throws Exception {
        Object instance = bean.getInstance();
        String methodName = bean.getConfig().getAttributeValue("init-method");
        if (methodName != null) {
            Method m = instance.getClass().getDeclaredMethod(methodName);
            m.invoke(instance);
        }
    }

    /**
     * 后初始化
     *
     * @param beans
     */
    private void processAfterInitialization(Bean bean, Map<String, Bean> beans) throws Exception {
        Object instance = bean.getInstance();
        String beanName = bean.getId();
        for (Map.Entry<String, Bean> entry : beans.entrySet()) {
            Object process = entry.getValue().getInstance();
            if (process instanceof BeanPostProcessor) {
                Object ret = ((BeanPostProcessor) process).postProcessAfterInitialization(instance, beanName);
                bean.setInstance(ret);
            }
        }
    }

    /**
     * 销毁
     *
     * @param bean
     */
    private void disposable(Bean bean) {
        Object instance = bean.getInstance();
        if (instance instanceof DisposableBean) {
            ((DisposableBean) instance).destroy();
        }
    }

    /**
     * 定制销毁
     *
     * @param bean
     */
    private void customDestory(Bean bean) throws Exception {
        Object instance = bean.getInstance();
        String methodName = bean.getConfig().getAttributeValue("destory-method");
        if (methodName != null) {
            Method m = instance.getClass().getDeclaredMethod(methodName);
            m.invoke(instance);
        }
    }


    @Override
    public Object getBean(String name) {
        Bean bean = beans.get(name);
        return bean == null ? null : bean.getInstance();
    }

    @Override
    public Object getBean(Class<?> type) {
        for (Map.Entry<String, Bean> entry : beans.entrySet()) {
            Bean bean = entry.getValue();
            Object instance = bean.getInstance();
            if (type.isInstance(instance)) {
                return instance;
            }
        }
        return null;
    }

    @Override
    public void close() throws Exception {
        System.out.println("close context...");
        for (Map.Entry<String, Bean> entry : beans.entrySet()) {
            Bean bean = entry.getValue();
            // 销毁 DisposableBean.destroy()
            disposable(bean);
            // 定制销毁 destory-method
            customDestory(bean);
        }
    }


}

