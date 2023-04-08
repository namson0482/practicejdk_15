package com.vuson.algorithm.java8.function;

import java.util.function.Function;

public class JavaMoney {

    public static void main(String[] args) {

        Function<String, Integer> func = x -> x.length();

        Integer apply = func.apply("mkyong");   // 6

        System.out.println(apply);

    }

}
