package com.vuson.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Son Vu
 * You are given an array of non-overlapping intervals where intervals[i] = [starti, endi] represent the start
 * and the end of the ith interval and intervals is sorted in ascending order by starti.
 * You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti
 * and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 *
 * Example 1:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 */
public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        int[][] tempArray = new int[intervals.length + 1][2];
        System.arraycopy(intervals, 0, tempArray, 0, intervals.length);
        tempArray[intervals.length][0] = newInterval[0];
        tempArray[intervals.length][1] = newInterval[1];

        Arrays.sort(tempArray, Comparator.comparingInt(a-> a[0]));


        List<int[]> result = new ArrayList<>();
        int []current = tempArray[0];
        result.add(current);

        for(int []loop : tempArray) {
            if(loop[0] <= current[1]) {
                current[1] = Math.max(loop[1], current[1]);
            } else {
                current = loop;
                result.add(current);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {

        int [][]intervals = new int[][]{
                                        {1, 3}
                                    ,   {6, 9},
        };

        int []newInterval = new int[] {2, 5};

        InsertInterval insertInterval = new InsertInterval();
        int [][]result = insertInterval.insert(intervals, newInterval);
        for (int i = 0; i < result.length; i++) {
            int[] temp = result[i];
            System.out.println();
            for (int i1 = 0; i1 < temp.length; i1++) {
                if (i1 == temp.length - 1) {
                    System.out.print(temp[i1] + " ");
                } else {
                    System.out.print(temp[i1] + ", ");
                }
            }
        }
    }
}
