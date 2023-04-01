package com.vuson.algorithm.arraylist;

import java.util.HashMap;

public class MaximumSubArray {

    public int calculate(int []a) {
        HashMap<Integer, Integer> first = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> last = new HashMap<Integer, Integer>();

        int []prefix = new int[a.length];

        int ans = -1;

        for(int i=0;i<a.length;i++) {
            if(i == 0) {
                prefix[i] = a[0];
            } else {
                prefix[i] = a[i] + prefix[i-1];
            }
            if(!first.containsKey(a[i])) {
                first.put(a[i], i);
            }

            last.put(a[i], i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("hey, there");

    }
}
