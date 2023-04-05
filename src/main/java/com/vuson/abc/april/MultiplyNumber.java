package com.vuson.abc.april;

import org.apache.logging.log4j.core.pattern.AbstractStyleNameConverter;

public class MultiplyNumber {


    public String multiplyTemp(String num1, String num2) {

        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int tempValue1 = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = tempValue1 + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }


    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] array = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int tempValue1 = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = tempValue1 + array[p2];

                array[p1] += sum/10;
                array[p2] = sum%10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int value : array) {
            if(!(value == 0 && sb.length() == 0)) {
                sb.append(value);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        MultiplyNumber multiplyNumber = new MultiplyNumber();
        String result = multiplyNumber.multiply("123", "456");
        System.out.println(result);
    }
}
