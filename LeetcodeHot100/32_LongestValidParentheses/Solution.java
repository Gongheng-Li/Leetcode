class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int longestLength = 0;
        for (int i = 1; i < s.length(); i++) {
            if (i - dp[i - 1] - 1 < 0 || s.charAt(i) == '(' || s.charAt(i - dp[i - 1] - 1) == ')') {
                dp[i] = 0;
                continue;
            }
            int result = dp[i - 1] + 2;
            int formerEnd = i - dp[i - 1] - 2;
            while (formerEnd > 0) {
                if (dp[formerEnd] == 0) {
                    break;
                }
                result += dp[formerEnd];
                formerEnd -= dp[formerEnd];
            }
            dp[i] = result;
            longestLength = Math.max(longestLength, result);
        }
        return longestLength;
    }

    public static void main(String[] args) {
        String parentheses = "()(()";
        Solution s = new Solution();
        System.out.println(s.longestValidParentheses(parentheses));
    }
}