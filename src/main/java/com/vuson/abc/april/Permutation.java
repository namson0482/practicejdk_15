package com.vuson.abc.april;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutation {

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> listTemp = new ArrayList<>();
        List<List<Integer>> listResult = new ArrayList<>();
        permutation(nums,listResult,listTemp);
        return listResult;
    }

    public void permutation(int []nums, List<List<Integer>> list, List<Integer> tempList) {

        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) {
                    continue;
                }

                tempList.add(nums[i]);
                permutation(nums,list, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    HashSet <List<Integer>> set = new HashSet<>();
    public List<List<Integer>> permuteUniqueIII(int[] nums) {
        boolean[] used = new boolean[nums.length];
        permute(new ArrayList<Integer>(),nums, used);
        return new ArrayList(set);
    }

    public void permute(List<Integer> permutation, int []nums, boolean[] used){

        if(permutation.size() == nums.length){
            set.add(new ArrayList<Integer>(permutation));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!used[i]){
                permutation.add(nums[i]);
                used[i] = true;
                permute(permutation, nums, used);
                permutation.remove(permutation.size()-1);
                used[i] =false;
            }

        }

    }

    public static void main(String[] args) {
        int []nums = {1, 1, 2};
        Permutation permutation = new Permutation();
        List list = permutation.permuteUniqueIII(nums);
        list.forEach(System.out::print);
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean []used = new boolean[nums.length];
        List<List<Integer>>  listResult = new ArrayList() ;
        List<Integer> listDynamic = new ArrayList();
        permutationUnique(nums, listResult, listDynamic, used);
        return listResult;
    }

    public void permutationUnique(int[] nums, List<List<Integer>> listResult, List<Integer> listDynamic, boolean[] used) {
        if (listDynamic.size() == nums.length) {
            listResult.add(new ArrayList(listDynamic));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])) continue;
                listDynamic.add(nums[i]);
                used[i] = true;
                permutationUnique(nums, listResult, listDynamic, used);
                used[i] = false;
                listDynamic.remove(listDynamic.size() - 1);
            }
        }
    }
}
