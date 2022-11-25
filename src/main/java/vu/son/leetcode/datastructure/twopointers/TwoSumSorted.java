package vu.son.leetcode.datastructure.twopointers;

public class TwoSumSorted {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while(left < right) {
            int temp = numbers[left] + numbers[right];
            if(temp > target) {
                right--;
            } else if(temp < target) {
                left++;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSumSorted twoSumSorted = new TwoSumSorted();
        int []numbers = new int[] {2, 7, 11, 15};
        int target = 9;
        int []result = twoSumSorted.twoSum(numbers, target);
        System.out.println(result[0] + "," + result[1]);
    }
}
