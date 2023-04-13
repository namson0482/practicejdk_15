package com.vuson.abc.april;

public class MatrixRotate {

    private static void rotate(int [][]matrix) {

        int n = matrix.length - 1;
        int length = n ;
        for(int i=0;i<(matrix.length+1)/2;i++) {
            for(int j=0;j<matrix[0].length/2;j++) {

                int temp = matrix[n-j][i];
                matrix[n-j][i] = matrix[n-i][n];
                matrix[n-i][n] = matrix[j][n -i];
                matrix[j][n -i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        for(int i=0;i<matrix.length;i++) {
            System.out.println("");
            for(int j=0;j<matrix[0].length;j++) {
                System.out.print(matrix[i][j] + "   ");
            }
        }

    }

    public static void main(String[] args) {
//        int matrix[][] = {{1, 2, 3},  {4, 5, 6}, {7, 8, 9}};
        int matrix[][] = {{1, 2, 3, 4},  {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        rotate(matrix);
    }
}
