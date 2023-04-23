package com.vuson.abc.april;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int item: nums) {
            if(map.containsKey(item)) {
                map.put(item, map.get(item) + 1);
            } else {
                map.put(item, 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer, Integer> item: map.entrySet()) {
            if(item.getValue() == 1)
                res.add(item.getKey());
        }
        return res.stream().mapToInt(q->q).toArray();
    }
}
