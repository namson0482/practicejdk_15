package com.vuson.abc.april.java8;

import java.util.*;
import java.util.stream.Collectors;

public class Apr71 {

    public static void testOptional() {
//        List<String> list = Arrays.asList(new String[]{"son", "huy"});
//        List<String> result = list.stream().map(String::toUpperCase).collect(Collectors.toList());


        Map<String, HashSet> map = new HashMap<>();
        map.computeIfAbsent("key", v -> new HashSet()).add(2);

        map.compute("key", (k, v) -> {
            v.add(3);
            return v;
        });

        Iterator<Map.Entry<String, HashSet>> item =  map.entrySet().iterator();
        while(item.hasNext()) {
            Map.Entry<String, HashSet> entry = item.next();
            System.out.println(entry.getValue());
        }

    }


    public static void main(String[] args) {
        testOptional();
    }

}
