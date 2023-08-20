package com.vuson.abc.april.java8.pattern.behavioral.strategy.object;

import com.vuson.abc.april.java8.pattern.behavioral.strategy.itf.Strategy;

public class OperationSubstract implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
