package com.vuson.abc.april.java8.pattern.behavioral.strategy;

import com.vuson.abc.april.java8.pattern.behavioral.strategy.object.OperationAdd;
import com.vuson.abc.april.java8.pattern.behavioral.strategy.object.OperationMultiply;
import com.vuson.abc.april.java8.pattern.behavioral.strategy.object.OperationSubstract;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        log.info("10 + 5 = {}",  context.executeStrategy(10, 5));

        context = new Context(new OperationSubstract());
        log.info("10 - 5 = {}", context.executeStrategy(10, 5));

        context = new Context(new OperationMultiply());
        log.info("10 * 5 = {}", context.executeStrategy(10, 5));
    }
}
