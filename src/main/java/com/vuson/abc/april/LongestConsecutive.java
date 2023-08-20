package com.vuson.abc.april;

import java.util.Arrays;

public class LongestConsecutive {

    private static int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int longestCount = 1;
        int result=Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]!=nums[i-1]){
                if((nums[i]-nums[i-1])==1)
                    longestCount++;
                else{
                    result=Math.max(result, longestCount);
                    longestCount=1;
                }
            }
        }
        return Math.max(result, longestCount);
    }

    public static void main(String[] args) {
//        int []nums = {100, 4, 200, 1, 3, 2};
        int []nums = {1,2,0,1};
        System.out.println(longestConsecutive(nums));
    }
}
