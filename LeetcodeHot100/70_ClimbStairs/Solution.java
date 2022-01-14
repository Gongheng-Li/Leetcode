class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        return calcSecondOrderMatrixPower(new int[][]{{1, 1}, {1, 0}}, n);
    }

    private int calcSecondOrderMatrixPower(int[][] matrix, int n) {
        int[][] result = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                result = calcSecondOrderMatrixMultiplication(result, matrix);
            }
            matrix = calcSecondOrderMatrixMultiplication(matrix, matrix);
            n >>= 1;
        }
        return result[0][0];
    }

    int[][] calcSecondOrderMatrixMultiplication(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[2][2];
        result[0][0] = matrix1[0][0] * matrix2[0][0] + matrix1[0][1] * matrix2[1][0];
        result[0][1] = matrix1[0][0] * matrix2[0][1] + matrix1[0][1] * matrix2[1][1];
        result[1][0] = matrix1[1][0] * matrix2[0][0] + matrix1[1][1] * matrix2[1][0];
        result[1][1] = matrix1[1][0] * matrix2[0][1] + matrix1[1][1] * matrix2[1][1];
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.climbStairs(3));
    }
}