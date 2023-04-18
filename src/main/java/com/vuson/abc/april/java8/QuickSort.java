package com.vuson.abc.april.java8;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

@Slf4j
public class QuickSort {


    @AllArgsConstructor
    static class Pair {
        int left;
        int right;
    }

    private static void swapValue(int []numbers, int i, int j) {
        numbers[i] = numbers[i] + numbers[j];
        numbers[j] = numbers[i] - numbers[j];
        numbers[i] = numbers[i] - numbers[j];
    }

    private static int partition(int []numbers, int begin, int end) {
        int pivot = numbers[end];
        int i = begin - 1;
        for(int j=begin;j<end;j++) {
            if(numbers[j] <= pivot) {
                i++;
                swapValue(numbers, i, j);
            }
        }
        i++;
        swapValue(numbers, i, end);
        return i;
    }

    private static void quickSort(int []numbers, int left, int right) {


        Stack<Pair> stack = new Stack();
        Pair pair = new Pair(left, right);
        stack.push(pair);
        do {
            pair = stack.pop();
            int pivot = partition(numbers, pair.left, pair.right);
            if (pivot - 1 > pair.left) {
                stack.push(new Pair(pair.left, pivot - 1));
            }
            if(pivot + 1 < pair.right) {
                stack.push(new Pair(pivot + 1, pair.right));
            }
        } while(!stack.empty());

    }

    private static void printArray(int []numbers) {
        System.out.println("");
        String stemp = "";

        if(numbers.length == 1) {
            stemp = numbers[0] + "";
        } else {
            for(int i=0;i<numbers.length - 1;i++) {
                stemp += numbers[i] + " ";
            }
            stemp += numbers[numbers.length - 1];
        }

        log.info("Array: {}", stemp);
    }


    public static void main(String[] args) {
       int []numbers = {10, 1, 24, 2, 0, 5};
        quickSort(numbers, 0, numbers.length - 1);
        printArray(numbers);
    }

}
