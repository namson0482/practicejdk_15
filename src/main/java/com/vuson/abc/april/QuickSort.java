package com.vuson.abc.april;

public class QuickSort {

    private static void swap(int []array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int partition(int []array, int begin, int end) {

        int pivot = array[end];
        int i = begin -1;

        for(int j=begin;j<end;j++) {
            if(array[j] <= pivot) {
                i++;
                swap(array, i, j);
            }
        }


        i++;
        swap(array, i, end);
        return i;
    }

    private static void quickSort(int []array, int begin, int end, int count) {
        count++;
        if(begin<end) {
            int pivot = partition(array, begin, end);
            quickSort(array, begin, pivot - 1, count);
            quickSort(array, pivot + 1, end, count);
        }
        if(count == 1) {
            print(array);
        }
    }

    private static void print(int []array) {
        System.out.println("");
        System.out.print("Array is: ");
        for(int item: array) {
            System.out.print(item + " ");
        }
    }

    public static void main(String[] args) {
        int []array  = {1, 9, 7, 2, 6, 5};
        quickSort(array, 0, array.length - 1, 0);

    }
}
