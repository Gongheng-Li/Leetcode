class Solution {
    public int maxProfit(int[] prices) {
        int holdStock = -1 * prices[0];
        int holdNothingInFreeze = 0;
        int holdNothing = 0;
        for (int i = 1; i < prices.length; i++) {
            int tempHoldStock = Math.max(holdStock, holdNothing - prices[i]);
            int tempToldNothingInFreeze = holdStock + prices[i];
            int tempHoldNothing = Math.max(holdNothingInFreeze, holdNothing);
            holdStock = tempHoldStock;
            holdNothingInFreeze = tempToldNothingInFreeze;
            holdNothing = tempHoldNothing;
        }
        return Math.max(holdNothingInFreeze, holdNothing);
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        Solution s = new Solution();
        System.out.println(s.maxProfit(prices));
    }
}