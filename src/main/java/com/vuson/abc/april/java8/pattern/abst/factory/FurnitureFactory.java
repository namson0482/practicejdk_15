package com.vuson.abc.april.java8.pattern.abst.factory;

import com.vuson.abc.april.java8.pattern.abst.itf.MaterialType;

public class FurnitureFactory {


    private FurnitureFactory() {

    }

    // Returns a concrete factory object that is an instance of the
    // concrete factory class appropriate for the given architecture.
    public static FurnitureAbstractFactory getFactory(MaterialType materialType) {
        switch (materialType) {
            case FLASTIC:
                return new FlasticFactory();
            case WOOD:
                return new WoodFactory();
            default:
                throw new UnsupportedOperationException("This furniture is unsupported ");
        }
    }
}
