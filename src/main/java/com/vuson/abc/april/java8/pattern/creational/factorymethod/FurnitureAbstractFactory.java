package com.vuson.abc.april.java8.pattern.creational.factorymethod;

import com.vuson.abc.april.java8.pattern.creational.factorymethod.itf.Chair;
import com.vuson.abc.april.java8.pattern.creational.factorymethod.itf.Table;

public abstract class FurnitureAbstractFactory {

    public abstract Chair createChair();

    public abstract Table createTable();

}
