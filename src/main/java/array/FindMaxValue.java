package array;

import java.util.ArrayList;
import java.util.List;

public class FindMaxValue {

	public static void findAll() {

		int[] arrayNum = { 4, 2, 1, 9 };
		List<List<Integer>> lstResult = new ArrayList<List<Integer>>();
		List<Integer> lstTemp = new ArrayList<Integer>();
		int maxValue = backtrack(lstResult, lstTemp, arrayNum, 3, 0);
		
		lstResult.forEach(System.out::println);
		System.out.println(maxValue);
	}

	public static int backtrack(List<List<Integer>> list, List<Integer> listTemp, int[] nums, int n, int start) {

		int maxValue = 0;
		if (listTemp.size() == n) {
			for (int value : listTemp) {
				maxValue += value;
			}
			list.add(new ArrayList<Integer>(listTemp));
		}
		for (int i = start; i < nums.length; i++) {
			listTemp.add(nums[i]);
			int tempMaxValue = backtrack(list, listTemp, nums, n, i + 1);
			if(tempMaxValue > maxValue) maxValue = tempMaxValue;
			listTemp.remove(listTemp.size() - 1);
		}
		return maxValue;
	}

	public static void main(String[] args) {

		findAll();
	}
}
