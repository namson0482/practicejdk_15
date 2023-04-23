package com.vuson.leetcode.matrix;

public class IISpiral {


    public int[][] generateMatrix(int n) {
        int [][]matrix = new int[n][n];
        int [][]directions = new int[][] {
                // Four directions that we will move: right, down, left, up.
                {0, 1},  // left -> right
                {1, 0},  // top -> bottom
                {0, -1}, // right -> left
                {-1, 0}, // bottom -> top
        };

        int [][]visited = new int[matrix.length][matrix[0].length];
        int currentDirection = 0;
        int changeDirection = 0;
        int number = 1;
        matrix[0][0] = number;
        int VISITED = 1;
        visited[0][0] = VISITED;
        int row = 0, rows = n;
        int col = 0, columns = n;
        while(changeDirection < 2) {
            while (row + directions[currentDirection][0] >= 0 &&
                    row + directions[currentDirection][0] < rows &&
                    col + directions[currentDirection][1] >= 0 &&
                    col + directions[currentDirection][1] < columns &&
                    visited[row + directions[currentDirection][0]]
                            [col + directions[currentDirection][1]] != VISITED) {
                changeDirection = 0;
                row = row + directions[currentDirection][0];
                col = col + directions[currentDirection][1];
                matrix[row][col] = number++;
                visited[row][col] = VISITED;
            }
            changeDirection++;
            currentDirection = (currentDirection + 1) % 4;
        }

        return matrix;
    }

    public int[][] generateMatrixOne(int n) {
        int [][]matrix = new int[n][n];
        int count = 0;
        int top, left;
        int bottom, right ;
        top = 0; left = 0;
        right = bottom = n - 1;
        while(count < n * n) {
            // traverse left -> right
            for(int col=left;col<=right;col++) {
                matrix[top][col] = ++count;

            }

            // top -> down
            for(int row=top+1;row<=bottom;row++) {
                matrix[row][right] = ++count;
            }

            if(top != bottom) {
                // right -> left
                for(int col=right-1;col>=left;col--) {
                    matrix[bottom][col] = ++count;
                }
            }

            if(left != right) {
                // bottom -> up
                for(int row=bottom-1;row>top;row--) {
                    matrix[row][left] = ++count;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return matrix;
    }

    public static void main(String[] args) {
        IISpiral spiral = new IISpiral();
        int [][]matrix = spiral.generateMatrix(4);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int i1 = 0; i1 < matrix[0].length; i1++) {
                System.out.print(matrix[i][i1] + "    ");
            }
        }
    }
}
