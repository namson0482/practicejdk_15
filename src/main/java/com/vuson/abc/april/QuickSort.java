package com.vuson.abc.april;

import lombok.AllArgsConstructor;

import java.util.Stack;

public class QuickSort {


    @AllArgsConstructor
    static class Point {
        int start;
        int end;
    }

    private static void swap(int []array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;



    }

    private static void quickSortNonRecursive(int []numbers) {
        int left = 0;
        int right = numbers.length - 1;
        Stack<Point> stack = new Stack();
        stack.add(new Point(left, right));
        for(;!stack.empty();) {
            Point point = stack.pop();
            int pivot = partition(numbers, point.start, point.end);
            if(pivot - 1 > point.start) {
                stack.push(new Point(point.start, pivot-1));
            }
            if(pivot + 1 < point.end) {
                stack.push(new Point(pivot + 1, point.end));
            }
        } while (!stack.empty());
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
//        int []array  = {1, 9, 7, 2, 6, 5};
//        quickSortNonRecursive(array);
//        print(array);
        int a = 5;
        int b = 3;
        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println(a + " " + b);
    }
}
