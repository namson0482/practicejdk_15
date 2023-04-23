package com.vuson.abc.april.java8.pattern.abst;

import com.vuson.abc.april.java8.pattern.abst.itf.Table;

public class PlasticTable implements Table {
    @Override
    public void create() {
        System.out.println("Create plastic table");
    }
}
