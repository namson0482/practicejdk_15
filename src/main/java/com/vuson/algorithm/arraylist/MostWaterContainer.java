package com.vuson.algorithm.arraylist;

public class MostWaterContainer {

    public int maxArea(int[] height) {
        int maxarea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int width = right - left;
            maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * width);
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxarea;
    }


    public static void main(String[] args) {

        MostWaterContainer mostWaterContainer = new MostWaterContainer() ;
        int []height = {1,8,6,2,5,4,8,3,7};
        System.out.println(mostWaterContainer.maxArea(height));
    }
}
