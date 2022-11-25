package vu.son.arraylist;

import java.util.HashMap;
import java.util.Map;

public class RemoveElementDuplicate {

    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 1);
        int k = 0;
        for(int i=1;i<nums.length;i++) {
            if(map.containsKey(nums[i])) {

            } else {
                map.put(nums[i], 1);
            }
        }
        return 0;
    }
}
