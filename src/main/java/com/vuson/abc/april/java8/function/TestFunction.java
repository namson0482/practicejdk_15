package com.vuson.abc.april.java8.function;

import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@FunctionalInterface
interface CallableFunction {
    float getNumber();

    static void print() {
        System.out.println("Function Callable Hello");
    }
}

@Slf4j
public class TestFunction {

    private static void test() {
        Optional<Optional<String>> optStringNested = Optional.of(Optional.of("sonvu"));
        Optional<Integer> optInt = optStringNested.flatMap(a->a).map(String::length);
        log.info("String length {}", optInt.orElseGet(() -> -1));

        CallableFunction call = () -> 10;
        log.info("{}", call.getNumber());


        List<List<String>> listStringNested = Arrays.asList(
                Arrays.asList(" SON", "NGUYEN", "TAM"),
                Arrays.asList("123", "445", "%12", "NGOC"),
                Arrays.asList("476", "425", "LINH", " %I ", " DAT")
        );

        List<String> listString = listStringNested.parallelStream().flatMap(a->a.stream())
                .filter(a -> a.trim().length() > 0 && a.trim().charAt(0) >= 'A' && a.trim().charAt(0) <= 'Z')
                .map(a -> a.trim().charAt(0) + "")
                .distinct()
                .collect(Collectors.toList());


        Set<String> setString = listStringNested.parallelStream().flatMap(a->a.parallelStream())
                .filter(a -> a.trim().length() > 0 && a.trim().charAt(0) >= 'A' && a.trim().charAt(0) <= 'Z')
                .map(a -> a.trim().charAt(0) + "")
                .collect(Collectors.toCollection(() ->
                        new TreeSet<String>()));


        listString.parallelStream().forEach(v -> System.out.print(v + " "));
        System.out.println("");
        setString.parallelStream().forEach(v -> System.out.print(v + " "));
        System.out.println("");
    }


    private static void testNested() {
        List<List<Integer>> listIntNested = Arrays.asList(
                Arrays.asList(1, 2, 4),
                Arrays.asList(8, 9, 10),
                Arrays.asList(88, 99, 110),
                Arrays.asList(82, 92, 101),
                Arrays.asList(18, 12, 11));

        List<Integer> listInt = listIntNested.parallelStream().flatMap(a->a.parallelStream())
                .filter(a -> a%2 == 0)
                .collect(Collectors.toList());

        int []arrayInt = listIntNested.parallelStream().flatMap(a->a.parallelStream()).mapToInt(a->a).toArray();

        int total = listIntNested.parallelStream().flatMap(a->a.parallelStream())
                .reduce(0, (a, b) -> a + b);

        int maximum = listInt.parallelStream().mapToInt(a->a).max().orElseGet(() -> 0);
        int minimum = listIntNested.parallelStream().flatMap(a->a.parallelStream())
                .min(Comparator.comparingInt(Integer::intValue)).orElseGet(() -> 0);

        log.info("Sum {} Max {} Min {}", total, maximum, minimum);

        int []arrayInteger = {20, 10, 5, 6, 7, 8};
        int sumEven = IntStream.of(arrayInteger).parallel().filter(v -> v%2==0).sum();
        int sumOdd = IntStream.of(arrayInteger).parallel().filter(v -> v%2!=0).sum();
        int sum = IntStream.of(arrayInteger).parallel().sum();
        log.info("Even {} Odd {} Sum {}", sumEven, sumOdd, sum);

        int value = Arrays.stream(arrayInt).filter(v -> v >= 10).reduce(0, (a, b) -> a + b)/2;
        log.info("Value {}", value);

    }

    public static void main(String[] args) {

        test();
        testNested();
    }
}
