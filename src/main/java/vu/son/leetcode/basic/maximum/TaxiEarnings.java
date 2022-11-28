package vu.son.leetcode.basic.maximum;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.StopWatch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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

@Slf4j
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

    public long maxTaxiEarningsTemp(int endPoint, int [][]rides ) {
        Point []points = new Point[rides.length];

        for(int i=0;i<rides.length;i++) {
            points[i] = new Point(rides[i][0], rides[i][1], rides[i][2]);
        }
        Arrays.sort(points, Comparator.comparingInt(a -> a.end));

        long []dp = new long[rides.length];
        dp[0] = points[0].profit;
        for(int i=1;i<rides.length;i++) {
            dp[i] = Math.max(dp[i-1], points[i].profit);
            for(int j=i-1;j>=0;j--) {
                if(points[j].end <= points[i].start) {
                    dp[i] = Math.max(dp[i], dp[j] + points[i].profit);
                    break;
                }
            }
        }

        return dp[rides.length-1];
    }

    public long maxTaxiEarnings2(int n, int[][] rides) {
        Arrays.sort(rides, (a, b) -> Integer.compare(a[1], b[1]));
        long[] dp = new long[n + 1];
        int k = 0;

        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1];
            while (k < rides.length && i == rides[k][1]) {
                int[] ride = rides[k++];
                dp[i] = Math.max(dp[i], dp[ride[0]] + ride[1] - ride[0] + ride[2]);
            }
        }

        return dp[n];
    }


    /**
     * Need to read again, still not understood clearly
     * @param n
     * @param rides
     * @return
     */
    public long maxTaxiEarningsPerformance(int n, int[][] rides) {
        Arrays.sort(rides, Comparator.comparingInt(a->a[0]));

        long[] dp = new long[n + 1];
        int j = 0;
        for(int i = 1; i <= n; ++i) {
            long beforeDpi = dp[i];
            dp[i] = Math.max(dp[i], dp[i - 1]);
            log.info("Begin i=" + i);
            log.info("dp[{}] = Math.max(dp[{}], dp[{} - 1]) = Math.max({}, {})", "i", "i", "i", beforeDpi, dp[i-1]);
            log.info("dp[{}]={}", i, dp[i]);
            while (j < rides.length && rides[j][0] == i) {
                log.info("      *** j={} && rides[{}][0]={}" , j, j, rides[j][0]);
                dp[rides[j][1]] = Math.max(dp[rides[j][1]], dp[i] + rides[j][1] - rides[j][0] + rides[j][2]);
                log.info("      *** dp[{}] = Math.max(dp[{}], dp[{}]) + rides[{}][1] - rides[{}][0] + rides[{}][2]) = {}", rides[j][1], rides[j][1], i, j, j, j, dp[rides[j][1]]);
                ++j;
            }
            log.info("---------------");
        }
        return dp[n];
    }


    /**
     *
     * @param n
     * @param arr
     * @return
     */
    public long maxTaxiEarnings(int n, int[][] arr) {

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<long[]> q = new PriorityQueue<>((a, b) -> {
            if (a[0] > b[0]) {
                return 1;
            } else {
                return -1;
            }
        });
        long max = 0;

        for (int i = 0; i < arr.length; i++) {
            while (!q.isEmpty() && arr[i][0] >= q.peek()[0]) {
                max = Math.max(max, q.peek()[1]);
                q.poll();
            }
            long val = arr[i][1] - arr[i][0];
            q.add(new long[]{arr[i][1], max + val + arr[i][2]});

        }

        while (!q.isEmpty()) {
            max = Math.max(max, q.peek()[1]);
            q.poll();
        }
        return max;
    }

    public static void main(String[] args) {

        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        int [][]ridesOne = new int[][]{
                                        {1,   6,   1},
                                        {3,   10,  2},
                                        {10,  12,  3},
                                        {11,  12,  2},
                                        {12,  15,  2},
                                        {13,  18,  1}
                                    };

        int [][]ridesTwo = new int[][]{

                {2,  5,  4},
                {1,  5,  1}
        };

        int [][]rides = ridesOne;


        TaxiEarnings taxi = new TaxiEarnings();
        long result = taxi.maxTaxiEarningsPerformance(20, rides);
        System.out.println(result);
        stopwatch.stop();
        long timeTaken = stopwatch.getTime();
        System.out.println(timeTaken + "ms");

    }
}
