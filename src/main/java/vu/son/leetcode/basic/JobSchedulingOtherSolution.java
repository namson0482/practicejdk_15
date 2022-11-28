package vu.son.leetcode.basic;

import org.apache.commons.lang.time.StopWatch;

public class JobSchedulingOtherSolution {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        final int N = startTime.length;

        // sorting based on end time
        for (int i = 0; i < N; i++) {
            int start = startTime[i];
            int end = endTime[i];
            int p = profit[i];

            int j = i - 1;
            while (j >= 0 && endTime[j] > end) {
                endTime[j + 1] = endTime[j];
                startTime[j + 1] = startTime[j];
                profit[j + 1] = profit[j];
                j--;
            }
            endTime[j + 1] = end;
            startTime[j + 1] = start;
            profit[j + 1] = p;
        }

        int[] max = new int[N];
        max[0] = profit[0];

        for (int i = 1; i < N; i++) {
            int prev = i - 1;
            int start = startTime[i];
            int end = endTime[i];
            int earn = profit[i];

            if (endTime[prev] > start) {
                while (prev >= 0 && endTime[prev] > start) {
                    prev--;
                }
                if (prev >= 0) {
                    max[i] = Math.max(max[prev] + earn, max[i - 1]);
                } else {
                    max[i] = Math.max(earn, max[i - 1]);
                }
            } else {
                max[i] = max[prev] + earn;
            }
        }
        return max[N - 1];
    }


    public static void main(String[] args) {
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        int []startTime = new int[]{1,  2,  4,   6,  3};
        int []endTime = new int[]  {3,  5,  6,   9,  10};
        int []profit = new int[]   {20, 20, 70,  60, 100};
        JobSchedulingOtherSolution job = new JobSchedulingOtherSolution();
        System.out.println(job.jobScheduling(startTime, endTime, profit));
        stopwatch.stop();
        long timeTaken = stopwatch.getTime();
        System.out.println(timeTaken + " ms");
    }
}
