class Solution {
    public int integerBreak(int n) {
        if (n < 4) {
            return n - 1;
        }
        int[] maxes = new int[n + 1];
        maxes[2] = 1;
        for (int i = 3; i <= n; i++) {
            maxes[i] = Math.max(2 * Math.max(maxes[i - 2], i - 2), 3 * Math.max(maxes[i - 3], i - 3));
        }
        return maxes[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.integerBreak(10));
    }
}