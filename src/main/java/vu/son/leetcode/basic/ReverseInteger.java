package vu.son.leetcode.basic;


import java.time.temporal.ValueRange;

/**
 * Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to
 * go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
 */
public class ReverseInteger {

    public static int reverse(int n) {
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

    public static void main(String[] args) {

        int temp = 1534236469;
        System.out.println(ReverseInteger.reverse(temp));
    }
}
