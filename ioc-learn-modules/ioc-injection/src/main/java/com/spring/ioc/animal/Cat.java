package com.spring.ioc.animal;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public class Cat extends AbstractAnimal {

    public Cat() {
        setAnimalName("猫");
    }

    public Cat(String animalName) {
        setAnimalName(animalName);
    }

    @Override
    public void communication() {
        System.out.println("喵喵喵");
    }
}
