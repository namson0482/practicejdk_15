package com.vuson.abc.april;

public class PlusNumber {
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
}
