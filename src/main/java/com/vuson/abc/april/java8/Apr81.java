package com.vuson.abc.april.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Apr81 {

    public static void main(String[] args) {
        testOptional();
    }

    public static void testOptional() {

        Optional<Optional<String>> optionNested = Optional.of(Optional.of("son"));
        Optional<Integer> optionalInt = optionNested.flatMap(q->q).map(String::length);
        System.out.println(optionalInt.get());

        Optional<Integer> optionInt2 = optionNested.map(m->m.get()).map(String::length);
        System.out.println(optionInt2);

        List<String> list = Arrays.asList(new String[]{"son", "huy", "nguyen", "vu"});
        list = list.stream().filter(v -> !v.equals("nguyen"))
                .filter(v-> !v.equals("vu"))
                .collect(Collectors.toList());

        List<List<String>> listTemp = Arrays.asList(Arrays.asList("a"), Arrays.asList("b"));

        List<String> listTwo = listTemp.stream().flatMap(Collection::stream).collect(Collectors.toList());

        list.forEach(v -> System.out.print(v + "  "));
    }

}
