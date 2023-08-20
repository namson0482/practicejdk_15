package com.vuson.abc.april.java8;

import java.util.Arrays;
import java.util.List;

public class StreamReduce {

    public static void testReduce() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int result = numbers
                .stream()
                .reduce(0, (subtotal, element) -> subtotal + element); // 21


        System.out.println(result);

        List<Integer> ages = Arrays.asList(25, 30, 45, 28, 32);
        int computedAges = ages.parallelStream().reduce(0, (a, b) -> a + b, Integer::sum);
    }

    public static void main(String[] args) {
        testReduce();
    }
}
