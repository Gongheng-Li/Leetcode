class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= i / 2; j++) {
                sum += dp[j - 1] * dp[i - j];
            }
            sum *= 2;
            if (i % 2 == 1) {
                sum += dp[i / 2] * dp[i / 2];
            }
            dp[i] = sum;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numTrees(19));
    }
}