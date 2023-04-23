package com.vuson.abc.april;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Stack;


@Data
@AllArgsConstructor
class Pair {
    private final int x;
    private final int y;

}

public class QuickSortNonRecursive {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[] a, int start, int end) {
        // Pick the rightmost element as a pivot from the array
        int pivot = a[end];

        // elements less than the pivot will go to the left of `pIndex`
        // elements more than the pivot will go to the right of `pIndex`
        // equal elements can go either way
        int pIndex = start;

        // each time we find an element less than or equal to the pivot,
        // `pIndex` is incremented, and that element would be placed
        // before the pivot.
        for (int i = start; i < end; i++) {
            if (a[i] <= pivot) {
                swap(a, i, pIndex);
                pIndex++;
            }
        }

        // swap `pIndex` with pivot
        swap(a, pIndex, end);

        // return `pIndex` (index of the pivot element)
        return pIndex;
    }

    // Iterative Quicksort routine
    public static void iterativeQuicksort(int[] a) {
        Stack<Pair> stack = new Stack<>();

        int start = 0;
        int end = a.length - 1;

        stack.push(new Pair(start, end));

        while (!stack.empty()) {
            Pair item = stack.pop();
            start = item.getX();
            end = item.getY();
            int pivot = partition(a, start, end);
            if (pivot - 1 > start) {
                stack.push(new Pair(start, pivot - 1));
            }
            if (pivot + 1 < end) {
                stack.push(new Pair(pivot + 1, end));
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {9, -3, 5, 2, 6, 8, -6, 1, 3};

        iterativeQuicksort(a);

        // print the sorted array
        System.out.println(Arrays.toString(a));
    }
}
