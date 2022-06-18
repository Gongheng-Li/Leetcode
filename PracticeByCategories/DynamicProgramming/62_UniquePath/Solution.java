import java.util.Arrays;

class Solution {
    public int uniquePaths(int m, int n) {
        if (m > n) {
            return uniquePaths(n, m);
        }
        int[] dp = new int[m];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n - 1; i++) {
            for (int j = 1; j < m; j++) {
                dp[j] = dp[j - 1] + dp[j];
            }
        }
        return dp[m - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(16, 16));
    }
}