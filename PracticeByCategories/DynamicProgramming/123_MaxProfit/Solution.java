class Solution {
    public int maxProfit(int[] prices) {
        int[] profit = new int[4]; // profit[0] ~ profit[3]分别表示持有第一只股票，已卖掉第一支股票，持有第二只股票和卖掉第二支股票的最大收益
        profit[0] = Integer.MIN_VALUE;
        profit[1] = 0;
        profit[2] = Integer.MIN_VALUE;
        profit[3] = 0;
        for (int price : prices) {
            int[] updatedProfit = new int[4];
            updatedProfit[0] = Math.max(profit[0], -price);
            updatedProfit[1] = Math.max(profit[1], price + profit[0]);
            updatedProfit[2] = Math.max(profit[2], profit[1] - price);
            updatedProfit[3] = Math.max(profit[3], profit[2] + price);
            profit = updatedProfit;
        }
        return Math.max(profit[1], profit[3]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
//        int[] prices = {1, 2, 3, 4, 5};
//        int[] prices = {7, 6, 4, 3, 1};
        int[] prices = {1};
        System.out.println(solution.maxProfit(prices));
    }
}