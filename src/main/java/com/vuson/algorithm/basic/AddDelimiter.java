package com.vuson.algorithm.basic;

public class AddDelimiter {

    private static String addDelimiter(String original, String separator) {
        String result = "";
        int k = 0;
        for (int i = original.length(); i > 0; i--) {
            result = original.charAt(i - 1) + result;
            k++;
            if (k % 3 == 0 && i > 1) {
                result = separator + result;
                k = 0;
            }
        }
        return result;
    }

    public static String addTwoNumbers(final String num1, final String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        byte[] nb1;
        byte[] nb2;
        if (num1.length() > num2.length()) {
            nb1 = num1.getBytes();
            nb2 = num2.getBytes();
        } else {
            nb2 = num1.getBytes();
            nb1 = num2.getBytes();
        }

        int maxLen = num1.length() >= num2.length() ? num1.length() : num2.length();
        for (int i = 1; i <= maxLen; i++) {
            int a = nb1.length - i >= 0 ? nb1[nb1.length - i] - 48 : 0;
            int b = nb2.length - i >= 0 ? nb2[nb2.length - i] - 48 : 0;
            int result = a + b + carry;

            if (result >= 10) {
                carry = 1;
                result = result - 10;
            } else {
                carry = 0;
            }
            sb.insert(0, result);
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String result = "1234";
        String temp =  addTwoNumbers("123324324", "26238432");
        System.out.println(temp);

    }
}
