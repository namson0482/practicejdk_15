package vu.son.grab;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrackPermutations {

	
	public List<List<Integer>> permute(int[] nums) {

		List<List<Integer>> list = new ArrayList<>();
		// Arrays.sort(nums); // not necessary
		backtrackPermutation(list, new ArrayList<>(), nums);
		return list;
	}

	private void backtrackPermutation(List<List<Integer>> list, List<Integer> tempList, int[] nums) {

		if (tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
		} else {
			lbl_point: for (int i = 0; i < nums.length; i++) {
				if (tempList.contains(nums[i]))
					continue lbl_point; // element already exists, skip
				tempList.add(nums[i]);
				backtrackPermutation(list, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	// Unique
	public List<List<Integer>> permuteUnique(int[] nums) {
		
		
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrackUnique(list, new ArrayList<>(), nums, new boolean[nums.length], 0);
		return list;
	}

	private void backtrackUnique(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used, int recursiveValue) {
		
		
		if (tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
					continue;
				}
				used[i] = true;
				tempList.add(nums[i]);
				backtrackUnique(list, tempList, nums, used, recursiveValue);
				recursiveValue++;
				used[i] = false;
				tempList.remove(tempList.size() - 1);
				if(recursiveValue - i == 1) {
					System.out.println("------------------");
					list.forEach(System.out::println);
				}
			}
		}
		
	}
	
//	public static void main(String[] args) {
//		
//		vu.son.algorithm.backtrack.vu.son.grab.BackTrackPermutations backTracking = new vu.son.algorithm.backtrack.vu.son.grab.BackTrackPermutations();
//		// give array nums of distinct integer 
//		int[] arrayIntsPermute = { 1, 1, 3};
//		List<List<Integer>> resultPermute = backTracking.permute(arrayIntsPermute);
//		resultPermute.forEach(System.out::println);
//	}	

	/**
	 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
	 * Input: nums = [1,1,2]
	 * Output: [[1,1,2],
 	 *			[1,2,1],
 	 *			[2,1,1]]
	 * @param args
	 */
	public static void main(String[] args) {

		vu.son.algorithm.backtrack.BackTrackPermutations backTracking = new vu.son.algorithm.backtrack.BackTrackPermutations();
		// Give integer collection
		int[] arrayIntsUnique = {1, 2, 3};
		List<List<Integer>> resultUnique = backTracking.permuteUnique(arrayIntsUnique);
		System.out.println("------------------");
		resultUnique.forEach(System.out::println);

	}
	 

}
