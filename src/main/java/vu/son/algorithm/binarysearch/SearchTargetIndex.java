package vu.son.algorithm.binarysearch;

import java.util.Arrays;
import java.util.Collections;

public class SearchTargetIndex {


    public static int search(int[] nums, int target) {

        Arrays.sort(nums);

        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int []nums = {1, 2, 3 , 5, 7, 8};
        int target = 5;
        System.out.println(SearchTargetIndex.search(nums, target));
    }
}