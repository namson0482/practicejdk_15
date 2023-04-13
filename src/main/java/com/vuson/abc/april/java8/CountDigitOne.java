package com.vuson.abc.april.java8;

public class CountDigitOne {

    public int countDigitOne(int num) {
        if (num == 0) return 0;

        int count = 0;
        int a = 0, b = 1;

        while (num / b > 0) {
            int m = (num / b) % 10;
            if (m > 0) {
                count += m * a + Math.min(b, num % (b * 10) - (b - 1));
            }

            a = 10 * a + b;
            b *= 10;
        }
        return count;
    }

}
