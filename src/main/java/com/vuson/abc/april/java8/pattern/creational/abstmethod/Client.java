package com.vuson.abc.april.java8.pattern.creational.abstmethod;

import com.vuson.abc.april.java8.pattern.creational.factorymethod.FurnitureAbstractFactory;
import com.vuson.abc.april.java8.pattern.creational.factorymethod.FurnitureFactory;
import com.vuson.abc.april.java8.pattern.creational.factorymethod.itf.Chair;
import com.vuson.abc.april.java8.pattern.creational.factorymethod.itf.MaterialType;
import com.vuson.abc.april.java8.pattern.creational.factorymethod.itf.Table;

public class Client {

    public static void main(String[] args) {

        FurnitureAbstractFactory factory = FurnitureFactory.getFactory(MaterialType.FLASTIC);

        Chair chair = factory.createChair();
        chair.create(); // Create plastic chair

        Table table = factory.createTable();
        table.create(); // Create plastic table
    }
}
