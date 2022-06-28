import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                if (dp[j - coin] != -1) {
                    if (dp[j] != -1) {
                        dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                    } else {
                        dp[j] = dp[j - coin] + 1;
                    }
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int[] coins = {2};
        Solution solution = new Solution();
        System.out.println(solution.coinChange(coins, 3));
    }
}