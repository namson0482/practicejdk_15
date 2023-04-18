package com.vuson.abc.april;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

public class Subset {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        Arrays.sort(nums);
        List<List<Integer>> listResult = new ArrayList<>();
        List<Integer> listDynamic = new ArrayList<>();
        subsetRecur(listResult, listDynamic, nums, 0);
        listResult.stream().forEach(System.out::println);
        return listResult;
    }

    private void subsetRecur(List<List<Integer>> listResult, List<Integer> listDynamic, int []nums, int start) {

        listResult.add(new ArrayList<>(listDynamic));
        if(start == nums.length) {
            return;
        }
        for(int i=start;i<nums.length;i++) {

            if(i > start && nums[i-1] == nums[i]) continue;

            listDynamic.add(nums[i]);
            subsetRecur(listResult, listDynamic, nums, i + 1);
            listDynamic.remove(listDynamic.size() - 1);
        }
    }

    public static void main(String[] args) {
        int []nums = {1, 2, 2};
        Subset subset = new Subset();
        subset.subsetsWithDup(nums);
    }
}
