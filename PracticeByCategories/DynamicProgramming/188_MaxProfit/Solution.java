class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0) {
            return 0;
        }
        int[] profit = new int[2 * k];
        for (int i = 0; i < k; i++) {
            profit[2 * i] = Integer.MIN_VALUE;
            profit[2 * i + 1] = 0;
        }
        for (int price : prices) {
            int[] updatedProfit = new int[2 * k];
            updatedProfit[0] = Math.max(profit[0], -price);
            for (int i = 1; i < k; i++) {
                updatedProfit[2 * i] = Math.max(profit[2 * i], profit[2 * i - 1] - price);
            }
            for (int i = 0; i < k; i++) {
                updatedProfit[2 * i + 1] = Math.max(profit[2 * i + 1], profit[2 * i] + price);
            }
            profit = updatedProfit;
        }
        return profit[2 * k - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] prices = {2, 4, 1};
        int[] prices = {3, 2, 6, 5, 0, 3};
        System.out.println(solution.maxProfit(0, prices));
    }
}