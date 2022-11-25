package vu.son.algorithm.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTracking {
	
	public List<List<Integer>> subsets(int[] nums) {
		
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
		
		if(tempList.size() > 0) {
			list.add(new ArrayList<>(tempList));
		}
		for (int i = start; i < nums.length; i++) {
			tempList.add(nums[i]);
			backtrack(list, tempList, nums, i + 1);
			tempList.remove(tempList.size() - 1);
		}
	}

	public static void main(String[] args) {
		
		BackTracking backTracking = new BackTracking() ;
		int[] arrayInts = {1, 2, 3};
		List<List<Integer>> result = backTracking.subsets(arrayInts);
		result.forEach(System.out::println);
	
	}
	
}


//int value = tempList.stream().collect(Collectors.summingInt(Integer::intValue));
//int total = tempList.stream().collect(Collectors.summingInt(x -> x));
//int value = tempList.stream().mapToInt(x -> x).sum();
//if(value == 9) {
//	System.out.println(tempList);
//}
