package com.vuson.abc.april.java8.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestOption {

    private static List<Integer> run(Optional<Optional<List<Integer>>> optionalListNested) {
        return optionalListNested.flatMap(q -> q).get();
    }

    private static void testOptional() {
        Optional<Optional<String>> optionalNested = Optional.of(Optional.of("vuson"));
        Optional<Integer> optionalInt = optionalNested.flatMap(q -> q).map(String::length);


        List<Integer> listInteger = new ArrayList<>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);

        Optional<Optional<List<Integer>>> optionalListNested = Optional.of(Optional.of(listInteger));
        int result = optionalListNested.flatMap(q -> q).get()
                .stream().reduce(0, (subtotal, element) -> subtotal + element);

//       int size = optionalListNested.flatMap(q -> q).orElseGet();

        int tempTotal = optionalListNested.flatMap(q -> q).orElseGet(() -> run(optionalListNested)).stream().reduce(0, (subtotal, element) -> subtotal + element);


        System.out.println(result);
    }


    public static void main(String[] args) {
        testOptional();
    }

}
