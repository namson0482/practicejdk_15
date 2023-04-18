package com.vuson.abc.april.java8.test;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ObjectGenerator {

    public static final List<ObjectChild> generate(int number) {
        List<ObjectChild> res = new ArrayList<>();
        for(int i=1;i<=number;i++) {
            res.add(new ObjectChild(Instant.now(), ((Math.random() * (10000 - 10)) + 10)));
        }
        return res;
    }
}
