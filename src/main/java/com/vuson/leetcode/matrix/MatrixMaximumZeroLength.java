package com.vuson.leetcode.matrix;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class MatrixMaximumZeroLength {

    int maxZerosLength = 0;
    long maxNumber = 1;

    // Four directions that we will move: right, down, left, up.
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private static int maxZeros(long number) {
        int res = 0;
        while (number % 10 == 0) {
            res++;
            number /= 10;
        }
        return res;
    }


    private void calculateZeros(Stack<Integer> result) {
        Iterator<Integer> iterator = result.iterator();
        int currentValue = 0;
        if(result.size() > 0) {
            currentValue = iterator.next();
        }

        while(iterator.hasNext()) {
            int tempNextValue = iterator.next();
            currentValue = currentValue * tempNextValue;
            int tempMaxZerosLength = maxZeros(currentValue);
            if(tempMaxZerosLength > maxZerosLength) {
                maxZerosLength = tempMaxZerosLength;
                maxNumber = currentValue;
                if(maxNumber == 360000000) {
                    System.out.println("Son");
                }
            }
        }

    }

    private void findMaximumPathZeros(int[][] matrix, int row, int col, int[][] visited, Stack<Integer> result) {

        if (row < 0 || row > matrix.length - 1 || col > matrix[0].length - 1 || col < 0) {
            return;
        }

        calculateZeros(result);


        for (int []direction: directions) {
            if(row + direction[0] < 0 || row + direction[0] > visited.length - 1 ||
                    col + direction[1] < 0 || col + direction[1] > visited[0].length - 1 ||
                    visited[row + direction[0]][col + direction[1]] == 101) {
                continue;
            }

            row += direction[0];
            col += direction[1];
            visited[row][col] = 101;
            result.add(matrix[row][col]);

            findMaximumPathZeros(matrix, row, col, visited, result);

            result.pop();
            visited[row][col] = 0;

            row -= direction[0];
            col -= direction[1];
        }
    }

    public long maxZerosPath(int[][] matrix) {


        maxZerosLength = 0;
        maxNumber = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int[][] visited = new int[matrix.length][matrix[0].length];
                visited[i][j] = 101;
                Stack<Integer> result = new Stack();

                result.add(matrix[i][j]);
                findMaximumPathZeros(matrix, i, j, visited, result);
            }
        }
        return maxNumber;
    }

    public static void main(String[] args) {
        int[][] mat =
                {
                        {10, 10, 10},
                        {10, 5, 10},
                        {10, 8, 9}
                };


//        int[][] mat =
//                {
//                        {10, 10},
//                        {10, 1},
//
//                };
        MatrixMaximumZeroLength matrixMaximumZeroLength = new MatrixMaximumZeroLength();
        System.out.println(matrixMaximumZeroLength.maxZerosPath(mat));
    }
}
