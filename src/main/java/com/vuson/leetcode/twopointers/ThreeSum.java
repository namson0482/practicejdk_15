package com.vuson.leetcode.datastructure.twopointers;

import java.util.HashMap;
import java.util.Map;

/**
 * @author son vu
 * Give an array integer and target. Find indices of the three number whose sum equal to a given target
 */
public class ThreeSum {

    public int[] findIndices(int []array, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<array.length;i++) {
            int currentSum = target - array[i];
            for(int j=i+1;j<array.length;j++) {
                int complement = currentSum - array[j];
                if(map.containsKey(complement)) {
                    return new int[]{i, map.get(complement), j};
                } else {
                    map.put(array[j], j);
                }
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int []array = new int[]{1, 4, 2, -2, 1};
        ThreeSum threeSum = new ThreeSum();
        int []result = threeSum.findIndices(array, 4);

        System.out.println(result[0] + "," + result[1] + "," + result[2]) ;
    }
}
