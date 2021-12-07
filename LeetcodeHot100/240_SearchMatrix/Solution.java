class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return quarterSearch(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    private boolean quarterSearch(int[][] matrix, int target, int startX, int startY, int endX, int endY) {
        if (startX > endX || startY > endY) {
            return false;
        }
        int middleX = (startX + endX) / 2;
        int middleY = (startY + endY) / 2;
        if (matrix[middleX][middleY] == target) {
            return true;
        } else if (matrix[middleX][middleY] < target) {
            if (quarterSearch(matrix, target, middleX + 1, startY, endX, middleY)) {
                return true;
            }
            if (quarterSearch(matrix, target, startX, middleY + 1, middleX, endY)) {
                return true;
            }
            return quarterSearch(matrix, target, middleX + 1, middleY + 1, endX, endY);
        } else {
            if (quarterSearch(matrix, target, startX, middleY,middleX - 1, endY)) {
                return true;
            }
            if (quarterSearch(matrix, target, middleX, startY, endX, middleY - 1)) {
                return true;
            }
            return quarterSearch(matrix, target, startX, startY, middleX - 1, middleY - 1);
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 4, 7, 11, 15},
                        {2, 5, 8, 12, 19},
                        {3, 6, 9, 16, 22},
                        {10, 13, 14, 17, 24},
                        {18, 21, 23, 26, 30}};
        Solution s = new Solution();
        System.out.println(s.searchMatrix(nums, 20));
    }
}