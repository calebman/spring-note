package com.spring.ioc;

import com.spring.ioc.animal.AnimalInterface;
import com.spring.ioc.zoo.ZooInterface;
import org.junit.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;

public class BeansTest extends SpringBaseTest {

    /**
     * 获取bean测试
     */
    @Test
    public void animalTest() {
        AnimalInterface cat = getContext().getBean("cat", AnimalInterface.class);
        cat.breathe();
        cat.communication();
        AnimalInterface dog = getContext().getBean("dog", AnimalInterface.class);
        dog.breathe();
        dog.communication();
        ZooInterface zoo = getContext().getBean("zoo", ZooInterface.class);
        zoo.breathe();
        zoo.communication();
    }

    /**
     * 设置注入测试
     */
    @Test(expected = NoSuchBeanDefinitionException.class)
    public void setInjectionTest() {
        AnimalInterface cat = getContext().getBean("setCat", AnimalInterface.class);
        cat.breathe();
        cat.communication();
        ZooInterface zoo = getContext().getBean("setZoo", ZooInterface.class);
        zoo.breathe();
        zoo.communication();
        // 此句会报异常 因为他是内部设值注入的参数 不会被实例化进IOC容器
        getContext().getBean("setDog", AnimalInterface.class).breathe();
    }

    /**
     * 构造注入测试
     */
    @Test(expected = NoSuchBeanDefinitionException.class)
    public void constructorInjectionTest() {
        AnimalInterface cat = getContext().getBean("constructorCat", AnimalInterface.class);
        cat.breathe();
        cat.communication();
        ZooInterface zoo = getContext().getBean("constructorZoo", ZooInterface.class);
        zoo.breathe();
        zoo.communication();
        // 此句会报异常 因为他是内部构造注入的参数 不会被实例化进IOC容器
        getContext().getBean("constructorDog", AnimalInterface.class).breathe();
    }
}
