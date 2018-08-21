package com.spring.ioc.zoo;

import com.spring.ioc.animal.AbstractAnimal;
import com.spring.ioc.animal.AnimalInterface;

import java.util.List;

/**
 * @author calebman
 * @date 2018/8/20
 * @description 动物园接口
 */
public interface ZooInterface extends AnimalInterface {

    /**
     * 获取动物园中的动物信息
     *
     * @return 动物列表
     */
    List<AbstractAnimal> getAnimalList();

}
