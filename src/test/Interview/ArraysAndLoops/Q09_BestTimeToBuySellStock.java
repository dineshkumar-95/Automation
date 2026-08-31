package org.example.Interview.ArraysAndLoops;

/**
 * Best Time to Buy and Sell Stock: Given prices[i] = price on day i, find max profit
 * from buying on one day and selling on a future day.
 * SDET: Analyzing performance benchmarks or verifying pricing fluctuation algorithms.
 */
public class Q09_BestTimeToBuySellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Single pass (best): " + maxProfitSinglePass(prices));
        System.out.println("Track min so far: " + maxProfitTrackMin(prices));
        System.out.println("Brute force: " + maxProfitBruteForce(prices));
    }

    // Best: one pass — keep min price and max profit — O(n) time, O(1) space
    public static int maxProfitSinglePass(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }
        return maxProfit;
    }

    // Same idea, alternate naming — O(n)
    public static int maxProfitTrackMin(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int buy = Integer.MAX_VALUE;
        int profit = 0;
        for (int price : prices) {
            buy = Math.min(buy, price);
            profit = Math.max(profit, price - buy);
        }
        return profit;
    }

    // Least optimal: try every buy/sell pair — O(n^2)
    public static int maxProfitBruteForce(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }
}
