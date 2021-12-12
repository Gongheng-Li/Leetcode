class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int minCoinNum = -1;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != -1) {
                    if (minCoinNum == -1) {
                        minCoinNum = dp[i - coin] + 1;
                    } else {
                        minCoinNum = Math.min(dp[i - coin] + 1, minCoinNum);
                    }
                }
            }
            dp[i] = minCoinNum;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1};
        Solution s = new Solution();
        System.out.println(s.coinChange(coins, 2));
    }
}