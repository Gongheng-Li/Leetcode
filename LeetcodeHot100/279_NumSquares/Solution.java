class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int maxRoot = (int) Math.sqrt(i);
            int minSquares = Integer.MAX_VALUE;
            for (int j = maxRoot; j >= 1; j--) {
                minSquares = Math.min(minSquares, 1 + dp[i - j * j]);
            }
            dp[i] = minSquares;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numSquares(16));
    }
}