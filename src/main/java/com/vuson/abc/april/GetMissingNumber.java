package com.vuson.abc.april;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.lang.reflect.Field;

@Slf4j
public class GetMissingNumber {

    public static int getMissingNumber(int[] numbers) {

        int result = -1;
        for(int i=1;i<=100;i++) {
            boolean find = false;
            for(int j=0;j<numbers.length;j++) {
                if(numbers[j] == i) {
                    find = true;
                    break;
                }
            }
            if(!find) {
                return i;
            }
        }
        return result;
    }

    private void initializeData(int []numbers) {
        for(int i=1;i<=100;i++) {
            if(i == 50) continue;
            numbers[i-1] = i;
        }
    }

    private static void testObject(Integer object) {
        object = Integer.valueOf(2);
//        try {
//            Field field = object.getClass().getDeclaredField("value");
//            field.setAccessible(true);
//            field.set(object, 2);
//        } catch (NoSuchFieldException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
    }

    void swap(int []numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    int partition(int []numbers, int left, int right) {

        int pivot = numbers[right];
        int i = left - 1;
        if (left < right) {
            for (int k = left; k < right; k++) {
                if (numbers[k] < pivot) {
                    i++;
                    swap(numbers, i, k);
                }
            }
        }
        i++;
        swap(numbers, i, right);
        return i;
    }

    void quickSort(int []numbers, int left, int right) {
        if(left < right) {
            int pivot = partition(numbers, left, right);
            quickSort(numbers, left, pivot - 1);
            quickSort(numbers,pivot + 1, right);
        }

    }

    void print(int []numbers) {

        String stemp = "";
        for(int item: numbers) {
            stemp += item + " ";
        }
        log.info("Arrays: {}", stemp.trim());
    }


    public static void main(String[] args) {
       int []numbers = new int[100];
        GetMissingNumber object = new GetMissingNumber();
        object.initializeData(numbers);
        log.info("Number missing {}", getMissingNumber(numbers));

        Integer objectInt = Integer.valueOf(55);
        log.info("Value {}", objectInt.intValue());
        testObject(objectInt);
        log.info("Value {}", objectInt.intValue());


        int []arrays = {9, 1, 8, 100, 20 , 10, 11, 54};
        object.print(arrays);
        object.quickSort(arrays, 0, arrays.length -1);
        object.print(arrays);
    }


}
