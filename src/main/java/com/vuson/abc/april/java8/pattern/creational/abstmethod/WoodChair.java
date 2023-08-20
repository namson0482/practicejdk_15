package com.vuson.abc.april.java8.pattern.creational.abstmethod;

import com.vuson.abc.april.java8.pattern.creational.factorymethod.itf.Chair;

public class WoodChair implements Chair {
    @Override
    public void create() {
        System.out.println("Create wood chair");
    }
}
