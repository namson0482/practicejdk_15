package com.vuson.algorithm.codility;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


/**
 * There are N hospitals. numbered from 0 to N-1. You are given a schedule of work in each of the hospitals for the tollowing M davs. The schedule is provided in the form of a two.
 * dimensional array A containing N rows, each row representing the schedule of one nosota. anc v columns. each column reor esentino one cav. Intecer annuentorr within
 * the range O..N-1_ and L within the range ..M-1] represents the ID of the doctor working at hospital K on day L. Note that sometimes an individual doctor may work at more than
 * one hospital even on the same  days.
 *
 * Write a function:
 *  class Solution { public int solution(int [][]A);  }
 *
 * that, given a matrix A consisting of N rows and M columns representing the hospitals schedules, finds the number of doctors working at more than one hospital
 *
 * 1. Given A = 1. 2. 21. 3. 1. 4]] the function should return 1
 *
 * The doctor with ID 1 works at both hospitals. The doctor with ID 2 works onlv at hospital number while the doctors with IDs 3 and 4 work onlv at hospital number .
 * 2. GIVen A = |1, 1, 5, 2, 31, 4, 5, 6, 4, 3, 19, 4, 4, 1, 5 , the tunction should return 4
 *
 *
 * The doctors with IDs 1. 3, 4 and 5 work at more than one hospital.
 * 3. Given A = [14, 3], [5, 5], [6, 2] 1, the function should return 0.
 *
 *
 * Each doctor works only at one hospital
 */
public class Hospital {

    public static int solve(int[][] A) {
        // each row => one hospital schedule
        // M column => days
        // A[K][L] => id of doc working at K hospital on L day
        int op = 0;
        Map<Integer, Set> docToHosp = new HashMap();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                int key = A[i][j];
                Set set = docToHosp.get(key);
                if (set == null) {
                    Set newSet = new HashSet<>();
                    newSet.add(i);
                    docToHosp.put(key, newSet);
                } else {
                    set.add(i);
                    docToHosp.put(key, set);
                }
            }
        }

        for (Map.Entry<Integer, Set> entry : docToHosp.entrySet()) {
            if (entry.getValue().size() > 1) {
                op++;
            }
        }

        // number of doctors working at more than one hospital!
        return op;
    }

    public static void main(String[] args) {
        int[][] A = {{1, 2, 2}, {3, 1, 4}};
//        int[][] A = {{1,1,5,2,3}, {4,5,6,4,3}, {9,4,4,1,5}};
//        int[][] A = {{4, 3}, {5, 5}, {6, 2}};
        System.out.println(solve(A));
    }
}
