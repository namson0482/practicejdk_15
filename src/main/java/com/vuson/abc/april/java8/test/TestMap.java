package com.vuson.abc.april.java8.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMap {

    private static Map<String, ObjectA> seedingMapBeans() {
        final Map<String, ObjectA> map = new HashMap<>();
        map.put("num_1", new ObjectA("vu", "son", 42));
        map.put("num_2", new ObjectA("vu", "thai", 46));
        map.put("num_3", new ObjectA("vu", "tien", 49));
        map.put("num_4", new ObjectA("vu", "lien", 52));
        return map;
    }

    private static Map<String, List<ObjectChild>> initilizeObject() {
        Map<String, List<ObjectChild>> child = new HashMap<>();
        seedingMapBeans().keySet().forEach(key -> child.put(key, ObjectGenerator.generate(10)));
        return child;
    }
}
