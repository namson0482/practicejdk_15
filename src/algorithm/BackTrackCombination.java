package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrackCombination {

	public List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, target, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
		if (remain < 0)
			return;
		else if (remain == 0)
			list.add(new ArrayList<>(tempList));
		else {
			for (int i = start; i < nums.length; i++) {
				tempList.add(nums[i]);
				backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	public static void main(String[] args) {

		BackTrackCombination backTrackCombination = new BackTrackCombination();
		int[] arrayInts = { 2, 3, 6, 7 };
		List<List<Integer>> result = backTrackCombination.combinationSum(arrayInts, 7);
		result.forEach(System.out::println);
	}
}
