import java.util.Arrays;

class Solution {
    public int uniquePaths(int m, int n) {
        if (m > n) {
            return uniquePaths(n, m);
        }
        m -= 1;
        n -= 1;
        long result = 1;
        for (int i = m + 1, j = 1; j <= n; i++, j++) {
            result = result * i / j;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(16, 16));
    }
}