package vu.son.leetcode.basic;

public class MaximumZeros {

    public static int maxZeros(long number) {
        int res = 0;
        while(number % 10 == 0) {
            res++;
            number /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        long number = 101100001;

        System.out.println("Zeros: " + maxZeros(number));
    }
}
