class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buyPrice = prices[0] + fee;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (buyPrice < prices[i]) {
                profit += prices[i] - buyPrice;
                buyPrice = prices[i];
            } else if (buyPrice > prices[i] + fee) {
                buyPrice = prices[i] + fee;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
//        int[] prices = {1, 3, 2, 8, 4, 9};
        int[] prices = {1, 3, 7, 5, 10, 3};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(prices, 3));
    }
}