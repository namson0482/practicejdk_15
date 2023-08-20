package com.vuson.abc.april;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UglyNumber {

    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min) {
                index2++;
                int temp = 2*ugly[index2];
                factor2 = temp;
            }

            if(factor3 == min) {
                index3++;
                int temp = 3*ugly[index3];
                factor3 = temp;

            }

            if(factor5 == min) {
                index5++;
                int temp = 5*ugly[index5];
                factor5 = temp;
            }

        }
        return ugly[n-1];
    }

//    public int uglyNumber(int n) {
//        int ugly[] = new int[n];
//        int index2 = 0, index3 = 0, index5 = 0 ;
//        int factor2 = 2, factor3 = 3, factor5 = 5;
//        ugly[0] = 1;
//        for(int i=1;i<n;i++) {
//            int min = Math.min(Math.min(factor2, factor3), factor5);
//            ugly[i] = min;
//            if(factor2 == min) {
//                factor2 = 2*ugly[++index2];
//            }
//            if(factor3 == min) {
//                 factor3 = 3*ugly[++index3];
//            }
//            if(factor5 == min) {
//                factor5 = 5*ugly[++index5];
//            }
//        }
//        return ugly[n-1];
//    }


    public int nthUglyNumberSecond(int n) {


        int count = 0;
        int i = 1;
        while(count < n) {
            if(isUgly(i)) {
                count++;
            }
            i++;
        }
        return --i;

    }

    public boolean isUgly(int n) {
        if (n == 0) return false;

        while (n % 2 == 0) {
            n = n / 2;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        while (n % 5 == 0) {
            n = n / 5;
        }

        return n == 1;
    }

    public static boolean isUglyNumber(int n) {
        if (n <= 0) return false;
        for (int value : new int[]{2, 3, 5}) {
            n = keepDividingWhenDivisible(n, value);
        }
        return n == 1;
    }


    private static int keepDividingWhenDivisible(int dividend, int divisor) {
        while (dividend % divisor == 0) {
            dividend /= divisor;
        }
        return dividend;
    }

    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        System.out.println(uglyNumber.nthUglyNumber(1352));
//        int n = 6;
//        log.info("Number {} is {}", n, isUglyNumber(n) ? "Ugly": "Not Ugly");

    }
}
