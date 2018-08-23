package com.spring.aop.action.mock;

import com.github.javafaker.Faker;

import java.util.Locale;

/**
 * @author calebman
 * @date 2018/8/21
 * @description
 */
public class FakerTest {

    public static void main(String[] args) {
        Faker faker = new Faker(Locale.SIMPLIFIED_CHINESE);
        System.out.println(faker.shakespeare().hamletQuote());
        System.out.println(faker.shakespeare().asYouLikeItQuote());
        System.out.println(faker.shakespeare().kingRichardIIIQuote());
        System.out.println(faker.shakespeare().romeoAndJulietQuote());
        System.out.println(faker.commerce().department());
    }
}
