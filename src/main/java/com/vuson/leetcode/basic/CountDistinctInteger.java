package vu.son.leetcode.basic;

import java.time.temporal.ValueRange;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Son Vu
 *
 * You are given an array nums consisting of positive integers.
 *
 * You have to take each integer in the array, reverse its digits, and add it to the end of the array.
 * You should apply this operation to the original integers in nums.
 *
 * Return the number of distinct integers in the final array.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 */
public class CountDistinctInteger {

    static int reverse(int n) {
        boolean negative = false;
        if(n < 0) {
            n = Math.abs(n);
            negative = true;
        }
        ValueRange range = ValueRange.of(0, 2147483647);
        int result = 0;
        long value = 0;
        while(n > 0) {
            value = (value * 10) + n%10;

            if(!range.isValidIntValue(value)) {
                return 0;
            }
            result = (int)value;
            n /= 10;
        }
        if(negative) {
            result = 0 - result;
        }
        return result;
    }

    public int countDistinctIntegers(int []nums) {
        int []tempNums = new int[nums.length * 2];
        System.arraycopy(nums, 0, tempNums, 0, nums.length);

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            int reverse = reverse(nums[i]);
            tempNums[nums.length+i] = reverse;
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], nums[i]);
            }
            if(!map.containsKey(reverse)) {
                map.put(reverse, reverse);
            }
        }
        tempNums = new int[map.size()];
        int i =0;
        System.out.print("Values in array: ");
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            tempNums[i++] = entry.getValue();
            System.out.print(entry.getValue() + "  ");
        }
        System.out.println("");
        return map.size();
    }

    public static void main(String[] args) {
        int []nums = new int[] {1, 13, 10, 12, 31};
        System.out.println("Size of array: " + new CountDistinctInteger().countDistinctIntegers(nums));
    }
}
