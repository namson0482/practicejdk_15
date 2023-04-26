package com.vuson.abc.april.java8.pattern.creational.factorymethod;

import com.vuson.abc.april.java8.pattern.creational.abstmethod.PlasticChair;
import com.vuson.abc.april.java8.pattern.creational.abstmethod.PlasticTable;
import com.vuson.abc.april.java8.pattern.creational.factorymethod.itf.Chair;
import com.vuson.abc.april.java8.pattern.creational.factorymethod.itf.Table;

public class FlasticFactory extends FurnitureAbstractFactory {

    @Override
    public Chair createChair() {
        return new PlasticChair();
    }

    @Override
    public Table createTable() {
        return new PlasticTable();
    }

}
