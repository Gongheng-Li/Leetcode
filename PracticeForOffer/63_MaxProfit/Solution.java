class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, profit = 0;
        for (int currentPrice : prices) {
            minPrice = Math.min(minPrice, currentPrice);
            profit = Math.max(profit, currentPrice - minPrice);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] test = {7, 1, 5, 3, 6, 4};
        Solution s = new Solution();
        System.out.println(s.maxProfit(test));
    }
}