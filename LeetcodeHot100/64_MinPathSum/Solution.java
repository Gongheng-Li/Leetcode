class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length - 1;
        int n = grid[0].length - 1;
        for (int i = m; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                if (i == m && j == n) {
                    continue;
                }
                int goRight = Integer.MAX_VALUE, goDown = Integer.MAX_VALUE;
                if (i < m) {
                    goDown = grid[i + 1][j];
                }
                if (j < n) {
                    goRight = grid[i][j + 1];
                }
                grid[i][j] = Math.min(goDown, goRight) + grid[i][j];
            }
        }
        return grid[0][0];
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}};
        Solution s= new Solution();
        System.out.println(s.minPathSum(grid));
    }
}