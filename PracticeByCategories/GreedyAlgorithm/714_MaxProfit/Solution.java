class Solution {
    public int maxProfit(int[] prices, int fee) {
        int holdingStock = -1 * prices[0], holdingNothing = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = holdingNothing;
            holdingNothing = Math.max(holdingNothing, holdingStock + prices[i] - fee);
            holdingStock = Math.max(holdingStock, holdingNothing - prices[i]);
        }
        return holdingNothing;
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(prices, 2));
    }
}