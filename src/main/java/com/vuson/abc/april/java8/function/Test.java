package com.vuson.abc.april.java8.function;

@FunctionalInterface
interface Calculable {
    double calculate();
    default boolean alive() {
        return true;
    }
}

public class Test {

    public void printResult(Calculable func) {
        System.out.println("Result: " + func.calculate());
    }

    Test() {
        printResult(() -> 3);

    }

    public static void main(String[] args) {
        new Test();
    }

}
