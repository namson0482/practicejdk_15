package com.vuson.abc.april;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayRemoveDuplicates {

    public int removeDuplicates(int []nums) {

        int insertIndex = 1;
        for(int i = 1; i < nums.length; i++){
            // We skip to next index if we see a duplicate element
            if(nums[i - 1] != nums[i]) {
                /* Storing the unique element at insertIndex index and incrementing
                   the insertIndex by 1 */
                nums[insertIndex] = nums[i];
                insertIndex++;
            }
        }
        return insertIndex;
    }


    private static int[] remove(int []numbers) {

        List<Integer> list = new ArrayList<>();
        list.add(numbers[0]);
        int index = 1;
        for(int i=1;i<numbers.length;i++) {
            if(numbers[i] != numbers[i-1]) {
                list.add(index++, numbers[i]);
            }
        }
        return list.stream().mapToInt(q->q).toArray();
    }


    public static void main(String[] args) {

        int []numbers = {1, 1, 2};
        ArrayRemoveDuplicates arrayRemoveDuplicates = new ArrayRemoveDuplicates();
        int []res = arrayRemoveDuplicates.remove(numbers);
        for(int item: res)
            System.out.print(item +" ");
    }

}
