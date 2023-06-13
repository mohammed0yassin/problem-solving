class Solution {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int buyPointer = 0;
        int sellPointer = 1;
        while (sellPointer < prices.length) {
            if (prices[buyPointer] < prices[sellPointer]) {
                int newMaxProfit = prices[sellPointer] - prices[buyPointer];
                profit = newMaxProfit > profit ? newMaxProfit : profit;
            } else {
                buyPointer = sellPointer;
            }
            sellPointer++;
        }
        return profit;
    }

    public static void main(String[] args) {
        // int[] prices = {7,1,5,3,6,4};
        // int[] prices = {7,6,4,3,1};
        int[] prices = {2,1,2,0,1};

        System.out.println(maxProfit(prices));
    }
}
