package com.spring.ioc.animal;

/**
 * @author calebman
 * @date 2018/8/20
 * @description
 */
public abstract class AbstractAnimal implements AnimalInterface {
    // 动物名称
    private String animalName;

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    @Override
    public void breathe() {
        System.out.printf("%s正在呼吸\n", getAnimalName());
    }
}
