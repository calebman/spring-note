### IOC介绍

* 控制反转容器
* 反转了对象的创建及依赖关系，Spring将对象的创建以及对象之间的依赖关系交给了IoC容器来管理，管理的标准，则是配置文件

### Bean的注入

#### 普通注入

```xml
    <bean id="cat" class="com.spring.ioc.animal.Cat"></bean>
    <bean class="com.spring.ioc.animal.Dog"></bean>
```

#### 设值注入

```xml
    <bean id="setCat" class="com.spring.ioc.animal.Cat">
        <property name="animalName" value="设值注入的猫"></property>
    </bean>
    <bean id="setZoo" class="com.spring.ioc.zoo.Zoo">
        <property name="animalList">
            <list>
                <ref bean="setCat"/>
                <bean id="setDog" class="com.spring.ioc.animal.Dog">
                    <property name="animalName" value="设值注入的狗"></property>
                </bean>
            </list>
        </property>
    </bean>
```

#### 构造注入

```xml
    <bean id="constructorCat" class="com.spring.ioc.animal.Cat">
        <constructor-arg index="0" value="构造注入的猫"></constructor-arg>
    </bean>
```

### Bean的装配

#### Bean的配置

| 属性                       | 描述            | 示例       | 备注                         |
| -------------------------- | --------------- | ---------- | ---------------------------- |
| id                         | 唯一标识        | myBean     | 默认为Bean的类名称首字母小写 |
| class                      | 类型            | org.MyBean | 必填                         |
| scope                      | 作用域          | singletion |                              |
| constructor-arg            | 构造参数        |            |                              |
| property                   | 设值参数        |            |                              |
| init-method/destory-method | 初始化/销毁方法 |            |                              |

#### 作用域

| 属性           | 描述                        | 备注 |
| -------------- | --------------------------- | ---- |
| singletion     | 单例模式                    | 默认 |
| prototype      | 每次使用都创建              |      |
| request        | 在web中针对一个http请求有效 |      |
| session        | 在web中针对一个http会话有效 |      |
| global seesion | 单点登录常用                |      |

```xml
    <bean id="singletionBeanScope" scope="singleton" class="com.spring.ioc.scope.BeanScope"></bean>
    <bean id="prototypeBeanScope" scope="prototype" class="com.spring.ioc.scope.BeanScope"></bean>
```

```java
    @Test
    public void singletionTest() {
        BeanScopeInterface beanScope = getContext().getBean("singletionBeanScope", BeanScopeInterface.class);
        System.out.println(beanScope.hashCode());
        beanScope = getContext().getBean("singletionBeanScope", BeanScopeInterface.class);
        System.out.println(beanScope.hashCode());
    }

    @Test
    public void prototypeTest() {
        BeanScopeInterface beanScope = getContext().getBean("prototypeBeanScope", BeanScopeInterface.class);
        System.out.println(beanScope.hashCode());
        beanScope = getContext().getBean("prototypeBeanScope", BeanScopeInterface.class);
        System.out.println(beanScope.hashCode());
    }
```

#### 生命周期

* 实例化

  构造方法调用，如果构造方法有参数注入则在此时调用

* 参数注入

  设值注入方法调用，如果有设值注入则在此时调用

* 资源注入

  如果类实现了如ApplicationContextAware/BeanNameAware等Aware接口则在此时调用接口方法注入资源

* 预初始化

  调用所有实现了BeanPostProcessor接口并处于IOC容器中类的postProcessBeforeInitialization方法

* 初始化

  如果类实现了InitializingBean接口则调用其afterPropertiesSet方法

* 定制初始化

  如果类配置了init-method/default-init-method则调用对应方法

* 后初始化

  调用所有实现了BeanPostProcessor接口并处于IOC容器中类的postProcessAfterInitialization方法

* 可以被使用，等待容器关闭

* 销毁

  如果类实现了DisposableBean接口则调用其destroy方法

* 定制销毁

  如果类配置了destory-method/default-destory-method则调用对应方法

```xml
    <!-- Lifecycle -->
    <bean id="beanLifecycle" class="com.spring.ioc.lifecycle.BeanLifecycle"
          init-method="init" destroy-method="destory">
        <property name="arg" value="chee"></property>
    </bean>
    <!-- BeanPostProcessor -->
    <bean class="com.spring.ioc.lifecycle.LifecycleBeanPostPorcessor"></bean>
```

```java
public class BeanLifecycle implements BeanLifecycleInterface, InitializingBean, DisposableBean, BeanNameAware {

    private String arg;

    public void setArg(String arg) {
        this.arg = arg;
        System.out.println("injection arg " + arg);
    }

    public BeanLifecycle() {
        System.out.println("instantiation");
    }

    @Override
    public void say() {
        System.out.println("say");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean init");
    }

    public void init() {
        System.out.println("init-method");
    }

    public void destory() {
        System.out.println("destory-method");
    }

    public void defaultInit() {
        System.out.println("default-init-method");
    }

    public void defaultDestory() {
        System.out.println("default-destory-method");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("BeanNameAware " + s);
    }
}
```



#### Aware接口

* 实现Aware接口的bean可以在初始化之后获取到Spring容器的相关资源
* 常用的Aware接口

1. ApplicationContextAware
2. BeanNameAware
3. BeanFactoryAware
4. ServletContextAware

```java
public class BeanAware implements BeanAwareInterface, ApplicationContextAware, BeanNameAware {
    private String beanName;
    private ApplicationContext context;

    @Override
    public void say() {
        System.out.println("bean name is " + beanName);
    }

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
```

