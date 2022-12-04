package vu.son.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class SpiralMatrix {

    public List<Integer> spiralOrderOne(int[][] matrix) {
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

    public List<Integer> spiralOrder(int[][] matrix) {
        int VISITED = 101;
        int rows = matrix.length;
        int columns = matrix[0].length;
        // Four directions that we will move: right, down, left, up.
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // Initial direction: moving right.
        int currentDirection = 0;
        // The number of times we change the direction.
        int changeDirection = 0;
        // Current place that we are at is (row, col).
        // row is the row index; col is the column index.
        int row = 0;
        int col = 0;
        // Store the first element and mark it as visited.
        List<Integer> result = new ArrayList<>();
        result.add(matrix[0][0]);
        matrix[0][0] = VISITED;
        while (changeDirection < 2) {
            while (row + directions[currentDirection][0] >= 0 &&
                    row + directions[currentDirection][0] < rows &&
                    col + directions[currentDirection][1] >= 0 &&
                    col + directions[currentDirection][1] < columns &&
                    matrix[row + directions[currentDirection][0]]
                            [col + directions[currentDirection][1]] != VISITED) {
                // Reset this to 0 since we did not break and change the direction.
                changeDirection = 0;
                // Calculate the next place that we will move to.
                row = row + directions[currentDirection][0];
                col = col + directions[currentDirection][1];
                result.add(matrix[row][col]);
                matrix[row][col] = VISITED;
            }
            // Change our direction.
            currentDirection = (currentDirection + 1) % 4;
            // Increment change_direction because we changed our direction.
            changeDirection++;
        }
        return result;
    }

    public static void main(String[] args) {
//        int [][] matrix = new int[][] {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
        int [][] matrix = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        List list = spiralMatrix.spiralOrder(matrix);
        list.forEach((name) -> System.out.print(name + " -> "));
    }
}
