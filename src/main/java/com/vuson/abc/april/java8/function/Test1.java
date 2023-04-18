package com.vuson.abc.april.java8.function;


@FunctionalInterface
interface Calculation {
    double cal();

    static String getValue() {
        return "Son";
    }

    default boolean isCal() {
        return true;
    }
}


public class Test1 {

    private static void doCalculate(Calculation calculation) {
        System.out.println(calculation.cal());
    }

    public static void main(String[] args) {
        doCalculate(() -> 4);
    }

}
