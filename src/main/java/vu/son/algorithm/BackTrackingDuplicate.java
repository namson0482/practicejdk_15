package vu.son.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrackingDuplicate {
	
	public List<List<Integer>> subsetsDuplicate(int[] nums) {
		
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrackDuplicate(list, new ArrayList<>(), nums, 0);
		list.sort((e1, e2) -> Integer.valueOf(e1.size()).compareTo(Integer.valueOf(e2.size())));
		return list;
	}

	private void backtrackDuplicate(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
		
		if(tempList.size() > 0) {
			
		}
		list.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; i++) {
			if(i > start && nums[i] == nums[i-1]) {
				continue; // skip duplicates
			}
			tempList.add(nums[i]);
			backtrackDuplicate(list, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

	public static void main(String[] args) {
		
		BackTrackingDuplicate backTracking = new BackTrackingDuplicate() ;
		int[] arrayInts = {1, 2, 2};
		List<List<Integer>> result = backTracking.subsetsDuplicate(arrayInts);
		result.forEach(System.out::println);
	}
}

//int value = tempList.stream().collect(Collectors.summingInt(Integer::intValue));
//int total = tempList.stream().collect(Collectors.summingInt(x -> x));
//int value = tempList.stream().mapToInt(x -> x).sum();
//if(value == 9) {
//	System.out.println(tempList);
//}
