package com.vuson.abc.april.java8.pattern.behavioral.strategy;

import com.vuson.abc.april.java8.pattern.behavioral.strategy.itf.Strategy;

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
