package com.vuson.abc.april;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


@Slf4j
public class CanPartition {
    public boolean canPartitionSecond(int[] nums) {

        int totalSum = IntStream.of(nums).boxed().reduce(0, (a, b) -> a + b);
        log.info("Total {} Half {}", totalSum, totalSum/2);
        // if totalSum is odd,it cannot be partitioned into equal sum subset
        if (totalSum % 2 != 0) return false;
        int subSetSum = totalSum / 2;
        int n = nums.length;
        List<Integer> listDynamic = new ArrayList<>();
        List<List<Integer>> listRes = new ArrayList<>();
        boolean result = dfsSecond(nums, n - 1, subSetSum, listRes, listDynamic);
        return result;
    }

    public boolean dfsSecond(int[] nums, int n, int subSetSum, List<List<Integer>> listRes, List<Integer> listDynamic) {

        if (subSetSum == 0) {
            log.info(listDynamic.toString());
            listRes.add(new ArrayList<>(listDynamic));
            return true;
        }
        if (n < 0 || subSetSum < 0) {
            return false;
        }
        listDynamic.add(nums[n]);
        boolean bValue1 = dfsSecond(nums, n - 1, subSetSum - nums[n], listRes, listDynamic);
        listDynamic.remove(listDynamic.size() - 1);
        boolean bValue2 = dfsSecond(nums, n - 1, subSetSum, listRes, listDynamic);
        return bValue1 || bValue2;
    }


    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        // find sum of all array elements
        for (int num : nums) {
            totalSum += num;
        }
        // if totalSum is odd, it cannot be partitioned into equal sum subset
        if (totalSum % 2 != 0) return false;
        int subSetSum = totalSum / 2;
        int n = nums.length;
        Boolean[][] memo = new Boolean[n + 1][subSetSum + 1];
        return dfs(nums, n - 1, subSetSum, memo);
    }

    public boolean dfs(int[] nums, int n, int subSetSum, Boolean[][] memo) {
        // Base Cases
        if (subSetSum == 0)
            return true;
        if (n == 0 || subSetSum < 0)
            return false;
        // check if subSetSum for given n is already computed and stored in memo
        if (memo[n][subSetSum] != null)
            return memo[n][subSetSum];
        boolean result = dfs(nums, n - 1, subSetSum - nums[n - 1], memo) ||
                dfs(nums, n - 1, subSetSum, memo);
        // store the result in memo
        memo[n][subSetSum] = result;
        return result;
    }

    public static void main(String[] args) {
//        int nums [] = {1, 5, 12, 6};
        int nums [] = {1, 2, 5};

        log.info(new CanPartition().canPartition(nums) + "");
    }
}
