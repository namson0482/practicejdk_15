package com.vuson.abc.april.java8.pattern.abst;

import com.vuson.abc.april.java8.pattern.abst.factory.FurnitureAbstractFactory;
import com.vuson.abc.april.java8.pattern.abst.factory.FurnitureFactory;
import com.vuson.abc.april.java8.pattern.abst.itf.Chair;
import com.vuson.abc.april.java8.pattern.abst.itf.MaterialType;
import com.vuson.abc.april.java8.pattern.abst.itf.Table;

public class Client {

    public static void main(String[] args) {

        FurnitureAbstractFactory factory = FurnitureFactory.getFactory(MaterialType.FLASTIC);

        Chair chair = factory.createChair();
        chair.create(); // Create plastic chair

        Table table = factory.createTable();
        table.create(); // Create plastic table
    }
}
