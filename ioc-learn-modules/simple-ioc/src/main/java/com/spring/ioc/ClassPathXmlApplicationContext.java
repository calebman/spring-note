package com.spring.ioc;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class ClassPathXmlApplicationContext implements BeanFactory {
    // 存储管理的beans
    private Map<String, Object> beans = new HashMap<String, Object>();

    public ClassPathXmlApplicationContext() throws IllegalAccessException, IOException, InstantiationException, NoSuchMethodException, JDOMException, InvocationTargetException, ClassNotFoundException {
        this("beans.xml");
    }

    /**
     * 通过xml配置来构造IOC容器
     *
     * @param xmlPath xml配置地址
     * @throws Exception
     */
    public ClassPathXmlApplicationContext(String xmlPath) throws JDOMException, IOException, IllegalAccessException, InstantiationException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException {
        // 读取配置节点的xml信息列表
        List<Element> elements = getBeanElements(xmlPath);
        for (Element element : elements) {
            // 实例化bean节点
            Bean bean = instanceBean(element);
            // 存储
            beans.put(bean.id, bean.obj);
            // 依赖注入
            injectionBean(element, bean);
        }
    }

    /**
     * 获取bean的配置信息
     *
     * @param xmlPath 配置文件路径
     * @return 配置节点列表
     * @throws JDOMException
     * @throws IOException
     */
    List<Element> getBeanElements(String xmlPath) throws JDOMException, IOException {
        SAXBuilder builder = new SAXBuilder();
        Document document = builder.build(this.getClass().getClassLoader().getResource(xmlPath));
        Element root = document.getRootElement();
        return root.getChildren("bean");
    }

    /**
     * 实例话一个bean
     *
     * @param element 配置节点
     * @return 实例化之后的对象
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    Bean instanceBean(Element element) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String id = element.getAttributeValue("id");
        String clazz = element.getAttributeValue("class");
        Bean bean = new Bean();
        bean.id = id;
        bean.obj = Class.forName(clazz).newInstance();
        return bean;
    }

    /**
     * 依赖注入
     *
     * @param element 配置节点
     * @param bean    实例化的bean
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    void injectionBean(Element element, Bean bean) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        for (Element propertyElement : element.getChildren("property")) {
            String name = propertyElement.getAttributeValue("name");
            String injectBean = propertyElement.getAttributeValue("bean");
            Object propertyObj = beans.get(injectBean);
            // 拼接setter方法
            // 如果参数为userMapper则对应方法的名称默认为setUserMapper
            String methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
            // 调用方法完成注入
            Method m = bean.obj.getClass().getDeclaredMethod(methodName, propertyObj.getClass());
            m.invoke(bean.obj, propertyObj);
        }
    }

    @Override
    public Object getBean(String name) {
        return beans.get(name);
    }

    class Bean {
        String id;
        Object obj;
    }
}

