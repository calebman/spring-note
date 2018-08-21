package com.spring.ioc.zoo;

import com.spring.ioc.animal.AbstractAnimal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author calebman
 * @date 2018/8/20
 * @description 动物园
 */
public class Zoo implements ZooInterface {

    List<AbstractAnimal> animalList = new ArrayList<>();

    public Zoo() {
    }

    public Zoo(List<AbstractAnimal> animalList) {
        this.animalList = animalList;
    }

    public void setAnimalList(List<AbstractAnimal> animalList) {
        this.animalList = animalList;
    }

    @Override
    public List<AbstractAnimal> getAnimalList() {
        return animalList;
    }

    @Override
    public void breathe() {
        if (animalList.size() == 0) {
            System.out.println("动物园中没有动物");
            return;
        }
        for (AbstractAnimal animal : animalList) {
            animal.breathe();
        }
    }

    @Override
    public void communication() {
        if (animalList.size() == 0) {
            System.out.println("动物园中没有动物");
            return;
        }
        for (AbstractAnimal animal : animalList) {
            animal.communication();
        }
    }
}
