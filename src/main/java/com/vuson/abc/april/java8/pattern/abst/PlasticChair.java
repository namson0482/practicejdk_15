package com.vuson.abc.april.java8.pattern.abst;

import com.vuson.abc.april.java8.pattern.abst.itf.Chair;

public class PlasticChair implements Chair {
    @Override
    public void create() {
        System.out.println("Create plastic chair");
    }
}
