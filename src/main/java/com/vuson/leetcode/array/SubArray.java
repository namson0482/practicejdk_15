package com.vuson.leetcode.array;


/**
 * @author Son Vu
 * Given an integer array nums, find the subarray which has the largest sum and return its sum.
 */
public class SubArray {

    public int[] indexMaxSubArray(int []nums) {
        int currentSubarray = nums[0];
        int maxSubarray = nums[0];
        int[] indices = new int[] {0, 0};
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            currentSubarray = Math.max(num, currentSubarray + num);
            if(currentSubarray > maxSubarray) {
                maxSubarray = currentSubarray;
                if(maxSubarray == nums[i]) {
                    indices[0] = indices[1] = i;
                } else {
                    indices[1] = i;
                }
            }
        }
        return indices;
    }

    public int maxSubArray(int[] nums) {
        int currentSubarray = nums[0];
        int maxSubarray = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            currentSubarray = Math.max(num, currentSubarray + num);
            maxSubarray = Math.max(maxSubarray, currentSubarray);
        }
        return maxSubarray;
    }

    public static void main(String[] args) {

        int []nums = new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        SubArray subArray = new SubArray();
        int []indices = subArray.indexMaxSubArray(nums);
        System.out.print("Index of Max Sum Sub Array: ");
        for (int i = 0; i < indices.length; i++) {
            System.out.print(indices[i] + "  ");
        }
        System.out.println();
        System.out.println("Max Sum Sub Array: " + subArray.maxSubArray(nums));

    }
}
