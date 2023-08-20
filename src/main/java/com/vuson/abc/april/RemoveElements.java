package com.vuson.abc.april;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveElements {

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;

    }

    public static void main(String[] args) {
        new RemoveElements().removeElement(new int[]{1, 2, 4, 2, 2, 4}, 2);
    }
}
