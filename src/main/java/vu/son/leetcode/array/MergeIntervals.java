package vu.son.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/**
 * @author Son Vu
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 * and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);

    }

    public static void main(String[] args) {
        int [][]intervals = new int[][] {
                                          {1,  6}
                                        , {2,  4}
                                        , {8,  10}
                                        , {15, 18}, };


//        int[][] intervals = new int[][]{
//                {1, 4}
//                , {1, 5},
//        };

//        int[][] intervals = new int[][]{
//                                         {1, 10}
//                                        , {2, 3}
//                                        , {4, 5}
//                                        , {6, 7}
//                                        , {8, 9}
//                                        , {1, 10}
//        };

        MergeIntervals mergeIntervals = new MergeIntervals();
        intervals = mergeIntervals.merge(intervals);
        for (int i = 0; i < intervals.length; i++) {
            int[] temp = intervals[i];
            System.out.println("");
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
