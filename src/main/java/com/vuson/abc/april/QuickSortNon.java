package com.vuson.abc.april;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.LinkedList;
import java.util.Stack;

public class QuickSortNon {

    @Data
    @AllArgsConstructor
    class Pair {
        final int X;
        final int Y;


    }

    private static void swap(int []array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static int partition(int []numbers, int begin, int end) {
        int pivot = numbers[end];
        int i = begin - 1;
        for(int j=begin;j<end;j++) {
            if(numbers[j]<=pivot) {
                i++;
                swap(numbers, i, j);
            }
        }
        i++;
        swap(numbers, i, end);
        return i;
    }

    private void quickSort(int[] numbers) {

        Stack<Pair> stack = new Stack();
        Pair p = new Pair(0, numbers.length - 1);
        stack.push(p);

        while(!stack.empty()) {
            Pair pair = stack.pop();
            int start = pair.getX();
            int end = pair.getY();
            int pivot = partition(numbers, start, end);
            if (pivot - 1 > start) {
                stack.push(new Pair(start, pivot - 1));
            }
            if (pivot + 1 < end) {
                stack.push(new Pair(pivot + 1, end));
            }

        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add("son");
        linkedList.add("vu");
        System.out.println(linkedList.pop());
    }
}
