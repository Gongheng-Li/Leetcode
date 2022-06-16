class Solution {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return matrixPow(n - 1)[0][0];
    }

    private int[][] matrixPow(int pow) {
        int[][] result = {{1, 0}, {0, 1}};
        int[][] base = {{1, 1}, {1, 0}};
        while (pow > 0) {
            if ((pow & 1) == 1) {
                result = matrixMul(result, base);
            }
            pow >>= 1;
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
        System.out.println(solution.fib(4));
    }
}