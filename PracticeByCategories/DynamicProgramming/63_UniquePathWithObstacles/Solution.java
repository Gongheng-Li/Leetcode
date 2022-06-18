class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int[] row : obstacleGrid) {
            dp[0] = row[0] == 0 ? dp[0] : 0;
            for (int j = 1; j < n; j++) {
                dp[j] = row[j] == 0 ? dp[j] + dp[j - 1] : 0;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {{0, 0}};
        Solution solution = new Solution();
        System.out.println(solution.uniquePathsWithObstacles(grid));
    }
}