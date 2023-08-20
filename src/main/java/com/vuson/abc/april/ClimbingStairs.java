package com.vuson.abc.april;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int []dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }


    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        int value = climbingStairs.climbStairs(2);
        log.info(value + "");
    }
}
