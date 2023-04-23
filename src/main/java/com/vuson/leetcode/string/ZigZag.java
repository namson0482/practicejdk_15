package com.vuson.leetcode.string;

public class ZigZag {

    //P     A       Y       P       A       L       I       S       H       I       R       I       N       G
    //0     1       2       3       4       5       6       7       8       9       10      11      12      13


    public static String convert(String s, int numRows) {
        if(numRows == 1) {
            return s;
        }
        StringBuilder ret = new StringBuilder();
        int length = s.length();
        int space = numRows * 2 - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < length; j += space) {
                ret.append(s.charAt(i + j)) ;
                if (i != 0 && i != numRows - 1 && j - i + space < length) {
                    ret.append(s.charAt(j + space - i)) ;
                }
            }
        }
        return ret.toString();
    }

    public static String convertTemp(String s, int numRows) {
        if (numRows == 1) return s;

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String input = "PAYPALISHIRING";
        System.out.println(ZigZag.convert(input, 4));
    }
    // PINALSIGYAHPI
    //"PINALSIGYAHRPI"
}
