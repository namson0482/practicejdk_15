package com.vuson.abc.april.java8.pattern.abst.factory;

import com.vuson.abc.april.java8.pattern.abst.itf.Chair;
import com.vuson.abc.april.java8.pattern.abst.itf.Table;

public abstract class FurnitureAbstractFactory {

    public abstract Chair createChair();

    public abstract Table createTable();

}
