package com.vuson.abc.april;

public class BestTimeToBuyAndSell {

    public int maxProfit1(int[] prices) {
        int left = 0, right = 1;
        int maxp = 0;
        int profit = 0;
        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                profit = prices[right] - prices[left];
                maxp = Math.max(maxp, profit);
            } else {
                left = right;
            }
            right++;
        }
        return maxp;
    }

    public int maxProfit(int[] prices) {
        int lowest = Integer.MAX_VALUE;
        int result = 0;
//        for (int i = 0; i < prices.length; i++) {
//            if (prices[i] < lowest) {
//                lowest = prices[i];
//            }
//            int today = prices[i] - lowest;
//            result = Math.max(result, today);
//        }

        for(int price: prices) {
            if(price < lowest) {
                lowest = price;
            }
            int today = price - lowest;
            result = Math.max(today, today);
        }
        return result;
    }




    public static void main(String[] args) {

        BestTimeToBuyAndSell bestTimeToBuyAndSell = new BestTimeToBuyAndSell();

//        int []prices = {1, 2, 4};
        int[] prices = {7,1,5,3,6,4};
        int temp = bestTimeToBuyAndSell.maxProfit(prices);
        System.out.println(temp);
    }
}
