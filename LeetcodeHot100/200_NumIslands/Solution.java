class Solution {
    public int numIslands(char[][] grid) {
        int number = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    number += 1;
                    helper(grid, i, j);
                }
            }
        }
        return number;
    }

    private void helper(char[][] grid, int x, int y) {
        grid[x][y] = '0';
        if (x > 0 && grid[x-1][y] == '1') {
            helper(grid, x - 1, y);
        }
        if (x < grid.length - 1 && grid[x+1][y] == '1') {
            helper(grid, x + 1, y);
        }
        if (y > 0 && grid[x][y - 1] == '1') {
            helper(grid, x, y - 1);
        }
        if (y < grid[0].length - 1 && grid[x][y+1] == '1') {
            helper(grid, x, y + 1);
        }
    }

    public static void main(String[] args) {
//        char[][] grid = {{'1', '1', '0', '0', '0'},
//                         {'1', '1', '0', '0', '0'},
//                         {'0', '0', '1', '0', '0'},
//                         {'0', '0', '0', '1', '1'}};
        char[][] grid = {{'1', '1', '1'},
                         {'0', '1', '0'},
                         {'1', '1', '1'}};
        Solution s = new Solution();
        System.out.println(s.numIslands(grid));
    }
}