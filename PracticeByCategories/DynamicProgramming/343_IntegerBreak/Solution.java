class Solution {
    public int integerBreak(int n) {
        int[] maxes = new int[n + 1];
        maxes[1] = 1;
        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(max, j * Math.max(maxes[i - j], i - j));
            }
            maxes[i] = max;
        }
        return maxes[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.integerBreak(2));
    }
}