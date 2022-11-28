package vu.son.leetcode.basic.maximum;

import org.apache.commons.lang.time.StopWatch;

import java.util.Arrays;
import java.util.Comparator;


/**
 * @author Son Vu
 * @datetime Sun 27 Nov - 2002
 *
 * We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].
 * You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.
 * If you choose a job that ends at time X you will be able to start another job that starts at time X.
 *
 * Example 1:
 * Input: startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 * Output: 120
 * Explanation: The subset chosen is the first and fourth job.
 * Time range [1-3]+[3-6] , we get profit of 120 = 50 + 70.
 *
 * Example 2:
 * Input: startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
 * Output: 150
 * Explanation: The subset chosen is the first, fourth and fifth job.
 * Profit obtained 150 = 20 + 70 + 60.
 */
public class JobSchdeduling {

    class Job {
        int start, end, profit;
        Job(int start, int end, int profit){
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }


    public int jobScheduling(int []startTime, int []endTime, int []profit) {
        int n = startTime.length;
        Job []jobs = new Job[startTime.length];
        for(int i=0;i<jobs.length;i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        int []dp = new int[startTime.length];
        Arrays.sort(jobs, Comparator.comparingInt(a -> a.end));
        dp[0] = jobs[0].profit;

        for(int i=1;i<n;i++) {
            dp[i] = Math.max(dp[i-1], jobs[i].profit);
            for(int j=i-1;j>=0;j--) {
                if(jobs[j].end <= jobs[i].start) {
                    dp[i] = Math.max(dp[i], jobs[i].profit + dp[j]);
                    break;
                }
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        int []startTime = new int[]{1,  2,  4,   6,  3};
        int []endTime = new int[]  {3,  5,  6,   9,  10};
        int []profit = new int[]   {20, 20, 70,  60, 100};
        JobSchdeduling job = new JobSchdeduling();
        System.out.println(job.jobScheduling(startTime, endTime, profit));
        stopwatch.stop();
        long timeTaken = stopwatch.getTime();
        System.out.println(timeTaken + " ms");
    }
}
