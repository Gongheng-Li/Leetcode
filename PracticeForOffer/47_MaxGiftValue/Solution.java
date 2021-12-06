class Solution {
    private int[][] cache;

    public int maxValue(int[][] grid) {
        cache = new int[grid.length][grid[0].length];
        return maxValueHelper(grid, 0, 0);
    }

    private int maxValueHelper(int[][] grid, int startRow, int startColumn) {
        if (cache[startRow][startColumn] != 0) {
            return cache[startRow][startColumn];
        } else {
            int result;
            if (startColumn >= grid[0].length - 1 && startRow >= grid.length - 1) {
                result = grid[grid.length - 1][grid[0].length - 1];
            } else if (startColumn >= grid[0].length - 1) {
                result = grid[startRow][startColumn] + maxValueHelper(grid, startRow + 1, startColumn);
            } else if (startRow >= grid.length - 1) {
                result = grid[startRow][startColumn] + maxValueHelper(grid, startRow, startColumn + 1);
            } else {
                result = grid[startRow][startColumn] + Math.max(maxValueHelper(grid, startRow + 1, startColumn),
                        maxValueHelper(grid, startRow, startColumn + 1));
            }
            cache[startRow][startColumn] = result;
            return result;
        }
    }
}