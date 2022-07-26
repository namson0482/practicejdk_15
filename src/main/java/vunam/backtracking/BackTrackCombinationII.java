package vunam.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrackCombinationII {

	public List<List<Integer>> combinationSum2(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrackSkipDuplicate(list, new ArrayList<>(), nums, target, 0);
		return list;

	}

	private void backtrackSkipDuplicate(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
		if (remain < 0)
			return;
		else if (remain == 0)
			list.add(new ArrayList<>(tempList));
		else {
			for (int i = start; i < nums.length; i++) {
				if (i > start && nums[i] == nums[i - 1])
					continue; // skip duplicates
				tempList.add(nums[i]);
				backtrackSkipDuplicate(list, tempList, nums, remain - nums[i], i + 1);
				tempList.remove(tempList.size() - 1);
			}
		}
	}
	
	public List<List<Integer>> combinationSum1(int[] nums, int target) {
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

		// Can't reuse same element in array
		BackTrackCombinationII backTrackCombinationII = new BackTrackCombinationII();
		int[] arrayInts = { 2, 4, 3, 6, 1 };
		List<List<Integer>> result = backTrackCombinationII.combinationSum2(arrayInts, 8);
		result.forEach(System.out::println);
		System.out.println("==========================================================================");
		System.out.println("==========================================================================");
		System.out.println("==========================================================================");
		result = backTrackCombinationII.combinationSum1(arrayInts, 8);
		result.forEach(System.out::println);
	}
}
