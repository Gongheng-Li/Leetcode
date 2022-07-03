class Solution {
    public int maxProfit(int[] prices) {
        int holdStock = -1 * prices[0], holdNothing = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = Math.max(holdStock + prices[i], holdNothing);
            holdStock = Math.max(holdStock, holdNothing - prices[i]);
            holdNothing = temp;
        }
        return holdNothing;
    }
}