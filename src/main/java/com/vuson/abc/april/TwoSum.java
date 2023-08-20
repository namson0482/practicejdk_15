package com.vuson.abc.april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TwoSum {

//    private ArrayList<Integer> nums;
//    private boolean is_sorted;
//
//    public TwoSum() {
//        this.nums = new ArrayList<Integer>();
//        this.is_sorted = false;
//    }
//
//    public void add(int number) {
//        this.nums.add(number);
//        this.is_sorted = false;
//    }
//
//    public boolean find(int value) {
//        if (!this.is_sorted) {
//            Collections.sort(this.nums);
//            this.is_sorted = true;
//        }
//        int low = 0, high = this.nums.size() - 1;
//        while (low < high) {
//            int twosum = this.nums.get(low) + this.nums.get(high);
//            if (twosum < value)
//                low += 1;
//            else if (twosum > value)
//                high -= 1;
//            else
//                return true;
//        }
//        return false;
//    }

    int[] nums;
    int N;

    public TwoSum() {
        nums = new int[10];
        N=0;
    }

    public void add(int number) {
        if ((N + 1) > nums.length) {
            nums = Arrays.copyOf(nums, nums.length*2);
        }
        nums[N++] = number;
        Arrays.sort(nums, 0, N);
    }

    public boolean find(int value) {
        int i=0, j=N-1, curSum = 0;
        while (i < j) {
            curSum = nums[i]+nums[j];
            if (curSum == value) {
                return true;
            } else if (curSum > value) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSum obj = new TwoSum();
        obj.add(1);
        obj.add(3);
        obj.add(5);
        obj.add(7);
        obj.add(8);
        obj.add(9);
        obj.add(10);
        obj.add(11);
        obj.add(12);
        obj.add(13);
        obj.add(14);
        System.out.println(obj.find(4) + "");
    }
}
