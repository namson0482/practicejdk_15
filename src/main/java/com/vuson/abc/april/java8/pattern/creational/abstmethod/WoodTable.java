package com.vuson.abc.april.java8.pattern.creational.abstmethod;

import com.vuson.abc.april.java8.pattern.creational.factorymethod.itf.Table;

public class WoodTable implements Table {
    @Override
    public void create() {
        System.out.println("Create wood table");
    }
}
