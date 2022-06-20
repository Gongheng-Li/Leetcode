class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < i / 2; j++) {
                count += 2 * dp[j] * dp[i - 1 - j];
            }
            if (i % 2 == 1) {
                count += dp[i / 2] * dp[i / 2];
            }
            dp[i] = count;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numTrees(1));
    }
}