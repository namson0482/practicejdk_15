package vu.son.leetcode.matrix;

public class MatrixMaximumZeroLength {

    int maxZeroLength = 0;
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

    private void findMaximumPathZeros(int[][] matrix, int row, int col, int[][] visited) {

        if (row < 0 || row > matrix.length - 1 || col > matrix[0].length - 1 || col < 0) {
            return;
        }

        if (visited[row][col] == 101) {
            return;
        }

        visited[row][col] = 101;

        long tempNumber = matrix[row][col];
        int tempMax = maxZeros(tempNumber * maxNumber);
        if (tempMax > maxZeroLength) {
            maxZeroLength = tempMax;
            maxNumber = tempNumber * maxNumber;
        }


        for (int i = 0; i < directions.length; i++) {
            row += directions[i][0];
            col += directions[i][1];

            findMaximumPathZeros(matrix, row, col, visited);

            row -= directions[i][0];
            col -= directions[i][1];
        }
    }

    public long maxZerosPath(int[][] matrix) {

        int maxZeroLengthTemp = 0;
        long maxNumberTemp = 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                maxZeroLength = 0;
                maxNumber = 1;
                int[][] visited = new int[matrix.length][matrix[0].length];
                findMaximumPathZeros(matrix, i, j, visited);
                if(maxZeroLength > maxZeroLengthTemp) {
                    maxZeroLengthTemp = maxZeroLength;
                    maxNumberTemp = maxNumber;
                }
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
        MatrixMaximumZeroLength matrixMaximumZeroLength = new MatrixMaximumZeroLength();
        System.out.println(matrixMaximumZeroLength.maxZerosPath(mat));
    }
}
