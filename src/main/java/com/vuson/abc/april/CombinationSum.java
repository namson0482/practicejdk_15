package com.vuson.abc.april;

import java.util.*;

public class CombinationSum {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set setResult = new HashSet();

        LinkedList<Integer> listDynamic = new LinkedList<>();
        Arrays.sort(candidates);
        combinationSumRecur(candidates, setResult, listDynamic, target);
        List<List<Integer>> result = new ArrayList<>(setResult);
        return result;
    }

    private void combinationSumRecur(int[] candidates, Set result, LinkedList<Integer> listDynamic, int remain) {
         if(remain == 0) {
             List<Integer> tempList = new ArrayList<>(listDynamic);
             Collections.sort(tempList);
             result.add(tempList);
         }
         if(remain < 0) return;

         for(int i=0;i<candidates.length;i++) {
             if(remain - candidates[i] < 0) continue;
             listDynamic.add(candidates[i]);
             combinationSumRecur(candidates, result, listDynamic, remain - candidates[i]);
             listDynamic.removeLast();
         }
    }

    public static void main(String[] args) {
        int []array = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = new CombinationSum().combinationSum(array, target);
        result.forEach(System.out::println);


    }
}
