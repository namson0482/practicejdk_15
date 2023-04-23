package com.vuson.leetcode.matrix;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Son Vu
 * Given an m x n integer matrix: matrix, if an element is 0, set its entire row and column to 0's.
 * You must do it in place.
 */
@Slf4j
public class SetMatrixZeroes {

    public void setZeroesTwo(int[][] matrix) {

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    int[] points = new int[]{i, j};
                    list.add(points);
                }
            }
        }

        Map mapRow = new HashMap();
        Map mapCol = new HashMap();

        for (int i = 0; i < list.size(); i++) {
            int[] points = list.get(i);
            int row = points[0];
            int col = points[1];
            if (!mapRow.containsKey(row)) {
                for (int j = 0; j < matrix[0].length; j++) {
                    matrix[row][j] = 0;
                }
                mapRow.put(row, row);
            }
            if (!mapCol.containsKey(col)) {
                for (int k = 0; k < matrix.length; k++) {
                    matrix[k][col] = 0;
                }
                mapCol.put(col, col);
            }
        }
    }


    public  void zero(int[][] matrix, int n, int m, int row, int col){
        for(int i=0;i<n;i++){
            matrix[i][col]=0;
        }
        for(int i=0;i<m;i++){
            matrix[row][i]=0;
        }
    }
    public void setZeroes(int[][] matrix) {
        // Write your code here..
        ArrayList<ArrayList<Integer>> arr=new ArrayList<>();
        int n=matrix.length;
        int m=matrix[0].length;
        int []dummy1=new int[n];
        int []dummy2=new int [m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    ArrayList<Integer> temp=new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    arr.add(new ArrayList<>(temp));
                    // dummy1[i]=1;
                    // dummy2[j]=1;
                }
            }
        }
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(dummy1[i]==1||dummy2[j]==1)
        //             matrix[i][j]=0;
        //     }
        // }

        for(int i=0;i<arr.size();i++){
            zero(matrix,n,m,arr.get(i).get(0),arr.get(i).get(1));
        }

    }

    public static void main(String[] args) {
//        int[][] matrix =
//                {
//                        {1, 1, 1},
//                        {1, 0, 1},
//                        {1, 1, 1}
//                };

        int[][] matrix =
                {
                        {0, 1, 2, 0},
                        {3, 4, 5, 2},
                        {1, 3, 1, 5}
                };
        long start = System.currentTimeMillis();

        SetMatrixZeroes setMatrixZeroes = new SetMatrixZeroes();
        setMatrixZeroes.setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "    ");
            }
        }
        long finish = System.currentTimeMillis();

        System.out.println();
        log.info("Time elapsed: {}ms", finish - start);

    }

}
