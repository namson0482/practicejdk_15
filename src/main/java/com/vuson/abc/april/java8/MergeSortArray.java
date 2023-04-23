package com.vuson.abc.april.java8;

public class MergeSortArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while ((i + j) < (m + n)) {
            if (i >= m) {
                result[k] = nums2[j];
                j++;
            } else if (j >= n) {
                result[k] = nums1[i];
                i++;
            } else {
                if (nums1[i] < nums2[j]) {
                    result[k] = nums1[i];
                    i++;
                } else {
                    result[k] = nums2[j];
                    j++;
                }
            }
            k++;
        }
        nums1 = result;
        for(int item: nums1) {
            System.out.print(item + " ");
        }

//        return result;
    }

    private static void printArray(int[] array) {
        System.out.println();
        for (int item : array) {
            System.out.print(item + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 5, 6};
        MergeSortArray mergeSortArray = new MergeSortArray();
        mergeSortArray.merge(nums1, 3, nums2, 3);
        //printArray(result);


    }

}
