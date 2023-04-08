package com.vuson.abc.april;

import java.util.*;

public class HappyNumber {

//    private int getNext(int number) {
//
//        int sum = 0;
//        while(number > 0) {
//            int d = number%10;
//            int square = d * d;
//            number = number/10;
//            sum += square;
//        }
//        return sum;
//    }
//    public boolean isHappy(int number) {
//
//        Set seen = new HashSet();
//        while(number != 1 && !seen.contains(number)) {
//            seen.add(number);
//            number = getNext(number);
//        }
//        return number == 1;
//    }

    private int getNext(int number) {
        int result = 0 ;
        while(number > 0) {
            result += Math.pow(number%10, 2);
            number = number/10;
        }
        return result;
    }

    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet();
        while(n!=1&& !seen.contains(n)) {
            seen.add(n);
            n = getNext(n);
        }
        return n == 1;
    }

    public static void main(String[] args) {
        int value = 19;
        System.out.println(new HappyNumber().isHappy(value));
    }
}
