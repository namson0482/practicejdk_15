package vu.son.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int top = 0;
        int left = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        int rows = matrix.length;
        int columns = matrix[0].length;
        int col, row;
        while (result.size() < rows * columns) {
            // left -> right
            for (col = left; col <= right; col++) {
                result.add(matrix[top][col]);
            }

            // move downward
            for (row = top + 1; row < bottom; row++) {
                result.add(matrix[row][right]);
            }

            // right -> left and make sure on a difference row
            if(top != bottom) {
                for (col = right - 1; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
            }

            // Make sure we are now on a different column.
            if (left != right) {
                // Traverse upwards.
                for (row = bottom - 1; row > top; row--) {
                    result.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return result;
    }

    public static void main(String[] args) {
        int [][] matrix = new int[][] {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List list = spiralMatrix.spiralOrder(matrix);
        list.forEach((name) -> System.out.print(name + " -> "));
    }
}
