package com.vuson.abc.april;

import java.util.ArrayList;
import java.util.List;

public class SumCloset {
    public int threeSum(int []nums, int target) {
        int bestdiff = Integer.MAX_VALUE;
        int best = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int diff = Math.abs(nums[i] + nums[j] + nums[k] - target);
                    if (diff < bestdiff) {
                        bestdiff = diff;
                        best = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        return best;
//        List<List<Integer>> listResult = new ArrayList<>();
//        List<Integer> listDynamic = new ArrayList();
//        int res = nums[0] + nums[1] + nums[2];
//        return findCloset(nums, target, listResult, listDynamic, 0, res);
    }

    private int findCloset(int []nums, int target, List<List<Integer>> listResult, List<Integer> listDynamic, int start, int res) {

        if(listDynamic.size() == 3) {
            int temp = listDynamic.get(0) + listDynamic.get(1) + listDynamic.get(2);
            return temp;
        }
        for(int i=start;i<nums.length;i++) {
            listDynamic.add(nums[i]);
            int temp = findCloset(nums, target, listResult, listDynamic, i+1, res);
            if(temp-target<res-target) {
                res = temp;
            }
            listDynamic.remove(listDynamic.size()-1);
        }
        return res;
    }

    public static void main(String[] args) {
        int []array = {-1, 2, 1, -4};
        SumCloset sumCloset = new SumCloset();
        int result = sumCloset.threeSum(array, 1);
        System.out.println(result);
    }


}
