package com.vuson.abc.april.java8.function;

@FunctionalInterface
public interface Flyable {
    void fly();

    default boolean alive() {
        return true;
    }

    String toString();
}
