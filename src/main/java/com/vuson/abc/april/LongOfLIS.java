package com.vuson.abc.april;

import lombok.extern.slf4j.Slf4j;

import java.util.TreeSet;

@Slf4j
public class LongOfLIS {
    public static int lengthOfLIS(int[] nums) {

        int length = nums.length;
        TreeSet<Integer> set = new TreeSet();

        for(int i=0; i<length; i++){
            Integer ceil = set.ceiling(nums[i]);
            if(ceil != null){
                set.remove(ceil);
            }
            set.add(nums[i]);
        }

        return set.size();
//        int[] dp = new int[nums.length];
//        Arrays.fill(dp, 1);
//
//        for (int i = 1; i < nums.length; i++) {
//            for (int j = 0; j < i; j++) {
//                if (nums[i] > nums[j]) {
//                    dp[i] = Math.max(dp[i], dp[j] + 1);
//                }
//            }
//        }
//
//        int longest = 0;
//        for (int c: dp) {
//            longest = Math.max(longest, c);
//        }
//
//        return longest;
    }


    private static int longest(int []arr) {
        TreeSet<Integer> tree = new TreeSet();
        for(int item:arr) {
            Integer value = tree.ceiling(item);
            if(value!=null) {
                tree.remove(value);
            }
            tree.add(item);
        }
        return tree.size();
    }


    public static void main(String[] args) {
//        int []nums = {4,10,4,3,8,9};
        int []nums = {10,9,2,5,3,7,101,6};
        int res = longest(nums);
        log.info(res + "");
    }
}
