class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        int[][] maxSideByEach = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == 0 || j == 0) {
                    maxSideByEach[i][j] = matrix[i][j] - '0';
                } else {
                    if (matrix[i][j] == '0') {
                        maxSideByEach[i][j] = 0;
                    } else {
//                        int horizontal = 0, vertical = 0;
//                        for (int k = i; k >= i - maxSideByEach[i - 1][j - 1]; k--) {
//                            if (matrix[k][j] == '0') {
//                                break;
//                            }
//                            horizontal += 1;
//                        }
//                        for (int k = j; k >= j - maxSideByEach[i - 1][j - 1]; k--) {
//                            if (matrix[i][k] == '0') {
//                                break;
//                            }
//                            vertical += 1;
//                        }
//                        maxSideByEach[i][j] = Math.min(horizontal, vertical);
                        maxSideByEach[i][j] = Math.min(maxSideByEach[i][j-1], maxSideByEach[i-1][j]);
                        maxSideByEach[i][j] = Math.min(maxSideByEach[i-1][j-1], maxSideByEach[i][j]) + 1;
                    }
                }
                maxSide = Math.max(maxSide, maxSideByEach[i][j]);
            }
        }
        return maxSide * maxSide;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'},
                           {'1', '0', '1', '1', '1'},
                           {'1', '1', '1', '1', '1'},
                           {'1', '0', '0', '1', '0'}};
        Solution s = new Solution();
        System.out.println(s.maximalSquare(matrix));
    }
}