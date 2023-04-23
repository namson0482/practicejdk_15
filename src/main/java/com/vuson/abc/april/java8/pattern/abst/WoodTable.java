package com.vuson.abc.april.java8.pattern.abst;

import com.vuson.abc.april.java8.pattern.abst.itf.Table;

public class WoodTable implements Table {
    @Override
    public void create() {
        System.out.println("Create wood table");
    }
}
