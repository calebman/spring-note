package com.spring.ioc.animal;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public class Dog extends AbstractAnimal {

    public Dog() {
        setAnimalName("狗");
    }

    public Dog(String animalName) {
        setAnimalName(animalName);
    }

    @Override
    public void communication() {
        System.out.println("汪汪汪");
    }
}
