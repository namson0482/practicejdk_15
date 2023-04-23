package com.vuson.abc.april.java8.pattern.factorymethod;

import com.vuson.abc.april.java8.pattern.factorymethod.itf.Bank;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BankFactory {

    public BankFactory() {

    }

    public static final Bank getBank(BankType bankType) {
        switch (bankType) {
            case TPBANK: return new TPBank();
            case VIETCOMBANK: return new VietcomBank();
            default: throw new IllegalArgumentException("This bank type is unsupported");
        }
    }
}
