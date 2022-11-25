package vu.son.grab;


import java.util.ArrayList;
import java.util.List;

public class FindMaxValue {

	public static void findArrayMax() {
/*
		int []arrayInteger = {2, 1, 3};
		Arrays.sort(arrayInteger);
		List<List<Integer>> listResult = new ArrayList<List<Integer>>();
		int maxValue = backtrack(listResult, new ArrayList<Integer>(), arrayInteger, 0, 2);
		listResult.sort((e1, e2) -> Integer.valueOf(e1.size()).compareTo(Integer.valueOf(e2.size())));
//		listResult.sort((e1, e2) -> {
//			if(e1.size()>e2.size())
//				return 1;
//			else if(e1.size()<e2.size()) 
//				return -1;
//			return 0;
//		});
		listResult.forEach(System.out::println);
		System.out.println("Max Value: " + maxValue);*/
	}

	public static int backtrack(List<List<Integer>> listResult, List<Integer> listTemp, int[] nums, int start, int n) {
		
		int maxValue = 0;
		if(listTemp.size() == n) {
			listResult.add(new ArrayList<Integer>(listTemp));
			for(int value: listTemp) {
				maxValue += value;
			}
		}
		for(int i=start;i<nums.length;i++) {
			listTemp.add(nums[i]);
			int tempMaxValue = 0;
			tempMaxValue = backtrack(listResult, listTemp, nums, i + 1, n);
			if(tempMaxValue > maxValue) 
				maxValue = tempMaxValue;
			listTemp.remove(listTemp.size() - 1);
		}
		return maxValue;
	}

	public static void main(String[] args) {

		findArrayMax();
	}
}
