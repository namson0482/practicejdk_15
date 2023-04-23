package com.vuson.abc.april.java8.pattern.abst.factory;

import com.vuson.abc.april.java8.pattern.abst.PlasticChair;
import com.vuson.abc.april.java8.pattern.abst.PlasticTable;
import com.vuson.abc.april.java8.pattern.abst.itf.Chair;
import com.vuson.abc.april.java8.pattern.abst.itf.Table;

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
