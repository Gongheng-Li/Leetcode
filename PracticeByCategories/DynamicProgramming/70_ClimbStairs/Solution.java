class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[][] result = matrixPow(n - 1);
        return result[0][0] + result[0][1];
    }

    private int[][] matrixPow(int n) {
        int[][] base = {{1, 1}, {1, 0}};
        int[][] result = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                result = matrixMul(result, base);
            }
            n >>= 1;
            base = matrixMul(base, base);
        }
        return result;
    }

    private int[][] matrixMul(int[][] matrix1, int[][] matrix2) {
        int[][] result = new int[2][2];
        result[0][0] = matrix1[0][0] * matrix2[0][0] + matrix1[0][1] * matrix2[1][0];
        result[0][1] = matrix1[0][0] * matrix2[0][1] + matrix1[0][1] * matrix2[1][1];
        result[1][0] = matrix1[1][0] * matrix2[0][0] + matrix1[1][1] * matrix2[1][0];
        result[1][1] = matrix1[1][0] * matrix2[0][1] + matrix1[1][1] * matrix2[1][1];
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(3));
    }
}