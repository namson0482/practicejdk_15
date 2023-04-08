package com.vuson.algorithm.java8.operator;

// Java program to implement division
// with large number
public class DivideLargeNumber {

    public static String longDivision(String number, int divisor) {

        // As result can be very
        // large store it in string
        // but since we need to modify
        // it very often so using
        // string builder
        StringBuilder result = new StringBuilder();
        // We will be iterating
        // the dividend so converting
        // it to char array
        char[] dividend = number.toCharArray();

        // Initially the carry
        // would be zero
        int carry = 0;

        // Iterate the dividend
        for (int i = 0; i < dividend.length; i++) {
            // Prepare the number to
            // be divided
            int x = carry * 10 + Character.getNumericValue(dividend[i]);

            // Append the result with
            // partial quotient
            result.append(x / divisor);
            // Prepare the carry for
            // the next Iteration
            carry = x % divisor;
        }

        // Remove any leading zeros
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) != '0') {
                // Return the result
                return result.substring(i);
            }
        }
        // Return empty string
        // if number is empty
        return "";
    }

    // Driver code
    public static void main(String[] args) {

        String number = "435345234";
        int divisor = 152;
        System.out.println(longDivision(number, divisor));
    }
}
