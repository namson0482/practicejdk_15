package com.vuson.abc.april.java8.pattern.creational.abstmethod;

import com.vuson.abc.april.java8.pattern.creational.factorymethod.itf.Table;

public class PlasticTable implements Table {
    @Override
    public void create() {
        System.out.println("Create plastic table");
    }
}
