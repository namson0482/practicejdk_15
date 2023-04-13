package com.vuson.abc.april;

import java.util.*;

public class InterSection {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int item: nums1) {
            set.add(item);
        }

        Set<Integer> result = new HashSet();
        for(int item: nums2) {
            if(set.contains(item) && !result.contains(item)) {
                result.add(item);
            }
        }
        return result.stream().mapToInt(q->q).toArray();

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] res = intersection(nums1, nums2);
        System.out.println("");
        for (int value : res) {
            System.out.print(value + " ");
        }
    }

}
