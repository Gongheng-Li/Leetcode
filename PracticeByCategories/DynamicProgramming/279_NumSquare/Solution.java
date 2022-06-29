import java.util.Arrays;

class Solution {
    public int numSquares(int n) {
        int squareRoot = (int) Math.sqrt(n);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 1; i <= squareRoot; i++) {
            int square = i * i;
            for (int j = square; j <= n; j++) {
                dp[j] = Math.min(dp[j], dp[j - square] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numSquares(14));
    }
}