package com.vuson.abc.april.java8.pattern.factorymethod;

import com.vuson.abc.april.java8.pattern.factorymethod.itf.Bank;

public class TPBank implements Bank {
    @Override
    public String getBankName() {
        return "TPBank";
    }
}
