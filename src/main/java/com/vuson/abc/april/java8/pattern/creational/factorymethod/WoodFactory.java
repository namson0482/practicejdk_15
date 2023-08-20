package com.vuson.abc.april.java8.pattern.creational.factorymethod;

import com.vuson.abc.april.java8.pattern.creational.abstmethod.WoodChair;
import com.vuson.abc.april.java8.pattern.creational.abstmethod.WoodTable;
import com.vuson.abc.april.java8.pattern.creational.factorymethod.itf.Chair;
import com.vuson.abc.april.java8.pattern.creational.factorymethod.itf.Table;

public class WoodFactory extends FurnitureAbstractFactory {

    @Override
    public Chair createChair() {
        return new WoodChair();
    }

    @Override
    public Table createTable() {
        return new WoodTable();
    }
}
