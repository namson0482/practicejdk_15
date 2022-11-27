package vu.son.leetcode.basic;

import org.apache.commons.lang.time.StopWatch;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Son Vu
 * @datetime Sun 27 Nov 2022
 *
 *
 *
 * There are n points on a road you are driving your taxi on. The n points on the road are labeled from 1 to n in the direction you are going, and you want to drive from point 1 to point n to make money by picking up passengers. You cannot change the direction of the taxi.
 *
 * The passengers are represented by a 0-indexed 2D integer array rides, where rides[i] = [starti, endi, tipi] denotes the ith passenger requesting a ride from point starti to point endi who is willing to give a tipi dollar tip.
 *
 * For each passenger i you pick up, you earn endi - starti + tipi dollars. You may only drive at most one passenger at a time.
 *
 * Given n and rides, return the maximum number of dollars you can earn by picking up the passengers optimally.
 *
 * Note: You may drop off a passenger and pick up a different passenger at the same point.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 5, rides = [[2,5,4],[1,5,1]]
 * Output: 7
 * Explanation: We can pick up passenger 0 to earn 5 - 2 + 4 = 7 dollars.
 * Example 2:
 *
 * Input: n = 20, rides = [[1,6,1],[3,10,2],[10,12,3],[11,12,2],[12,15,2],[13,18,1]]
 * Output: 20
 * Explanation: We will pick up the following passengers:
 * - Drive passenger 1 from point 3 to point 10 for a profit of 10 - 3 + 2 = 9 dollars.
 * - Drive passenger 2 from point 10 to point 12 for a profit of 12 - 10 + 3 = 5 dollars.
 * - Drive passenger 5 from point 13 to point 18 for a profit of 18 - 13 + 1 = 6 dollars.
 * We earn 9 + 5 + 6 = 20 dollars in total.
 */
public class TaxiEarnings {


    class Point {
        int start;
        int end;
        int tips;
        int profit;
        Point(int start, int end, int tips) {
            this.start = start;
            this.end = end;
            this.tips = tips;
            this.profit = (end - start) + tips;
        }
    }

    public int maxTaxiEarnings(int n, int [][]rides ) {
        Point []points = new Point[n];

        for(int i=0;i<n;i++) {
            points[i] = new Point(rides[i][0], rides[i][1], rides[i][2]);
        }
        Arrays.sort(points, Comparator.comparingInt(a -> a.end));

        int []dp = new int[n];
        dp[0] = points[0].profit;
        for(int i=1;i<n;i++) {
            dp[i] = Math.max(dp[i-1], points[i].profit);
            for(int j=i-1;j>=0;j--) {
                if(points[j].end <= points[i].start) {
                    dp[i] = Math.max(dp[i], dp[j] + points[i].profit);
                }
            }
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        int [][]rides = new int[][]{    {1,   6,   1},
                                        {3,   10,  2},
                                        {10,  12,  3},
                                        {11,  12,  2},
                                        {12,  15,  2},
                                        {13,  18,  1}
                                    };

        TaxiEarnings taxi = new TaxiEarnings();
        int result = taxi.maxTaxiEarnings(rides.length, rides);
        System.out.println(result);
        stopwatch.stop();
        long timeTaken = stopwatch.getTime();
        System.out.println(timeTaken + " ms");
    }
}
