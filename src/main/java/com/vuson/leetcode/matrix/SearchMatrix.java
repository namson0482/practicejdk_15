package com.vuson.leetcode.matrix;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Son Vu
 * Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 */
@Slf4j
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length == 0) {
            return false;
        }

        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;

        while(top < bottom) {
            int mid = (top + bottom)/2;
            if(matrix[mid][0] > target) {
                bottom = mid - 1;
            } else if(matrix[mid][0] < target) {
                if(matrix[mid][right] >= target) {
                    top = mid;
                    bottom = mid;
                } else {
                    top = mid + 1;
                }
            } else {
                return true;
            }
        }

        for(int j=0;j<matrix[0].length;j++) {
            if(matrix[top][j] == target) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix =
                {
                        {1, 3, 5, 7},
                        {10, 11, 16, 20},
                        {23, 30, 34, 60},
                        {75, 82, 86, 90},
                };

        SearchMatrix searchMatrix = new SearchMatrix();
        log.info("Result: {}", searchMatrix.searchMatrix(matrix, 30));
    }
}
