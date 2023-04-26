package com.vuson.abc.april.java8.pattern.creational.factorymethod.object;

import com.vuson.abc.april.java8.pattern.creational.factorymethod.itf.Bank;

public class VietcomBank implements Bank {
    @Override
    public String getBankName() {
        return "VietcomBank";
    }
}
