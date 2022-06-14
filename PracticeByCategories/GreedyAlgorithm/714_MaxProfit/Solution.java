class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buyPrice = prices[0] + fee;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] + fee < buyPrice) {
                buyPrice = prices[i] + fee;
            } else if (prices[i] > buyPrice) {
                profit += prices[i] - buyPrice;
                buyPrice = prices[i];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(prices, 2));
    }
}