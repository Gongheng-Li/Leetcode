class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int longestLength = 0;
        for (int i = 1; i < s.length(); i++) {
            if (i - dp[i - 1] - 1 < 0 || s.charAt(i) == '(' || s.charAt(i - dp[i - 1] - 1) == ')') {
                dp[i] = 0;
                continue;
            }
            dp[i] = dp[i - 1] + 2;
            if (i - dp[i - 1] - 2 > 0) {
                dp[i] += dp[i - dp[i - 1] - 2];
            }
            longestLength = Math.max(longestLength, dp[i]);
        }
        return longestLength;
    }

    public static void main(String[] args) {
        String parentheses = "()(()";
        Solution s = new Solution();
        System.out.println(s.longestValidParentheses(parentheses));
    }
}