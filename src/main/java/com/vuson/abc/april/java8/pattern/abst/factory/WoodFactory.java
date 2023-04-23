package com.vuson.abc.april.java8.pattern.abst.factory;

import com.vuson.abc.april.java8.pattern.abst.WoodChair;
import com.vuson.abc.april.java8.pattern.abst.WoodTable;
import com.vuson.abc.april.java8.pattern.abst.itf.Chair;
import com.vuson.abc.april.java8.pattern.abst.itf.Table;

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
