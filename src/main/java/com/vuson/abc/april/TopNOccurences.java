package com.vuson.abc.april;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

@AllArgsConstructor
class Object {
    int value;
    int occur;
}

@Slf4j
public class TopNOccurences {




    private static void getTopOcurrencies(int []arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int item: arr) {
            if(map.containsKey(item)) {
                map.replace(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
        }

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o1.getValue() < o2.getValue() ? 1 : -1);
        for(int i=0;i<2;i++) {
            Map.Entry<Integer, Integer> item = list.get(i);
            log.info("Element {} occur {}", item.getKey(), item.getValue());
        }

    }

    public static void main(String[] args) {
        int []arr = {1, 2, 1, 1, 2, 3, 3, 3, 3, 1, 1};
        getTopOcurrencies(arr);
    }

}
