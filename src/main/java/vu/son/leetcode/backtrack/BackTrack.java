package vu.son.leetcode.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * BackTrack algorithm
 */
public class BackTrack {

    public List<List<Integer>> subSets(int []nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList();
        backTrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backTrack(List<List<Integer>> list, List<Integer> subList, int []nums, int start) {
        if(subList.size() > 0) {
            list.add(new ArrayList<>(subList));
        }

        for(int i=start;i<nums.length;i++) {
            subList.add(nums[i]);
            backTrack(list, subList, nums, i+1);
            subList.remove(subList.size() - 1);
        }
    }

    public static void main(String[] args) {

        int []numbers = new int[] {1, 2};
        BackTrack backTrack = new BackTrack();
        List<List<Integer>> result = backTrack.subSets(numbers);
        result.forEach(System.out::println);
    }
}
