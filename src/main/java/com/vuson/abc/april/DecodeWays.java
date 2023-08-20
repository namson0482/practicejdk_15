package com.vuson.abc.april;

public class DecodeWays {

    public int numDecodings(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        int n = input.length();
        int[] array = new int[n + 1];
        array[0] = 1;
        array[1] = input.charAt(0) != '0' ? 1 : 0;
        for (int i = 2; i <= n; i++) {
            int first = Integer.valueOf(input.substring(i - 1, i));
            int second = Integer.valueOf(input.substring(i - 2, i));
            if (first >= 1 && first <= 9) {
                array[i] += array[i-1];
            }
            if (second >= 10 && second <= 26) {
                array[i] += array[i-2];
            }
        }
        return array[n];
    }



    public static void main(String[] args) {
        String a = "60";


        DecodeWays decodeWays = new DecodeWays();
        int count = decodeWays.numDecodings(a);
        System.out.println(count);
    }
}
