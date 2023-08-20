package com.vuson.abc.april.java8.pattern.creational.abstmethod;

import com.vuson.abc.april.java8.pattern.creational.factorymethod.itf.Chair;

public class PlasticChair implements Chair {
    @Override
    public void create() {
        System.out.println("Create plastic chair");
    }
}
