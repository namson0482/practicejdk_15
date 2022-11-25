package vu.son.leetcode.datastructure.twopointers;

import java.util.Arrays;

public class TwoSumArraySorted {

    public int[] findTwoSum(int []nums, int target) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            if(nums[left] + nums[right] == target) {
                return new int[] {left, right};
            } else if(nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int []nums = new int[] {15, 2, 14, 6, 8, 9, 14, 4};
        int target = 15;

        TwoSumArraySorted twoSumArraySorted = new TwoSumArraySorted();
        int []result = twoSumArraySorted.findTwoSum(nums, target);
        if(result.length > 0) {
            System.out.print(result[0] + "," + result[1]);
        }
    }
}
