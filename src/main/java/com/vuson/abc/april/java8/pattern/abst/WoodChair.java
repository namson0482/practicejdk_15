package com.vuson.abc.april.java8.pattern.abst;

import com.vuson.abc.april.java8.pattern.abst.itf.Chair;

public class WoodChair implements Chair {
    @Override
    public void create() {
        System.out.println("Create wood chair");
    }
}
