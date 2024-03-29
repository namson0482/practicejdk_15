package com.vuson.leetcode.datastructure.twopointers;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Son Vu
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */
public class TwoSum {

    public int[] findTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.findTwoSum(nums, target);
        for (int value : result) {
            System.out.println(value + "");
        }
    }
}
