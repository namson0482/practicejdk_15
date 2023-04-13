package com.vuson.abc.april.java8;

public class QuickSort {

    public static void main(String[] args) {
        int []array = new int[]{6, 5, 4, 8, 7, 9};
        int left = 0;
        int right = array.length - 1;
        quickSort(array, left, right);
        printArray(array);
    }

    private static void printArray(int []array) {
        System.out.println("");
        for(int item: array) {
            System.out.print(item + " ");
        }
    }

    private static void quickSort(int []array, int left, int right) {
        if(left < right) {
            int partition = partition(array, left, right);
            quickSort(array, left, partition - 1);
            quickSort(array, partition + 1, right);
        }
    }

    private static int partition(int []array, int left, int right) {
        int pivot = array[right];
        int i = left - 1;
        for(int j=left;j<right;j++) {
            if(array[j]<=pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        i++;
        int temp = array[i];
        array[i] = array[right];
        array[right] = temp;
        return i;
    }
}
