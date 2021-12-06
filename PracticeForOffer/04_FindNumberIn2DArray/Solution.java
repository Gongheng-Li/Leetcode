class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        return findNumberInPartRegion(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
    }

    private boolean findNumberInPartRegion(int[][] matrix, int target, int xStart, int xEnd, int yStart, int yEnd) {
        if (xStart > xEnd || yStart > yEnd) {
            return false;
        } else if (xStart == xEnd && yStart == yEnd) {
            return (matrix[xStart][yStart] == target);
        }
        int xMid = (xStart + xEnd) / 2;
        int yMid = (yStart + yEnd) / 2;
        if (matrix[xMid][yMid] == target) {
            return true;
        } else {
            boolean existsInUpLeftPart = findNumberInPartRegion(matrix, target, xMid + 1, xEnd, yStart, yMid - 1);
            boolean existsInDownRightPart = findNumberInPartRegion(matrix, target, xStart, xMid - 1, yMid + 1, yEnd);
            if (matrix[xMid][yMid] < target) {
                boolean existInDownPart = findNumberInPartRegion(matrix, target, xMid, xMid, yMid + 1, yEnd);
                boolean existInRightPart = findNumberInPartRegion(matrix, target, xMid + 1, xEnd, yMid, yMid);
                return existInDownPart || existInRightPart ||existsInUpLeftPart || existsInDownRightPart
                        || findNumberInPartRegion(matrix, target, xMid + 1, xEnd, yMid + 1, yEnd);
            } else {
                boolean existInUpPart = findNumberInPartRegion(matrix, target, xMid, xMid, yStart, yMid - 1);
                boolean existInLeftPart = findNumberInPartRegion(matrix, target, xStart, xMid - 1, yMid, yMid);
                return existInUpPart || existInLeftPart || existsInUpLeftPart || existsInDownRightPart
                        || findNumberInPartRegion(matrix, target, xStart, xMid - 1, yStart, yMid - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = {{1,  4,  7,  11, 15},
                          {2,  5,  8,  12, 19},
                          {3,  6,  9,  16, 22},
                          {10, 13, 14, 17, 24},
                          {18, 21, 23, 26, 30}};
        System.out.println(s.findNumberIn2DArray(matrix, 20));
    }
}