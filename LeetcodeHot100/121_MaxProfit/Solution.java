class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyInPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            maxProfit = Math.max(maxProfit, price - buyInPrice);
            buyInPrice = Math.min(buyInPrice, price);
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(s.maxProfit(prices));
    }
}