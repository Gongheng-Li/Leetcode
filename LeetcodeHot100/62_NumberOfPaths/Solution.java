class Solution {
    public int uniquePaths(int m, int n) {
        long numerator = 1, denominator = 1;
        int total = m - 1 + n - 1;
        int select = Math.min(m - 1, n - 1);
        for (int i = 0; i < select; i++) {
            numerator *= (total - i);
            denominator *= i + 1;
        }
        return (int) (numerator / denominator);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniquePaths(3, 7));
    }
}