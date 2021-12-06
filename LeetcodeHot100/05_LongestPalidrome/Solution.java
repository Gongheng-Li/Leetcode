class Solution {
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        int longestStart = 0, longestLength = 1;
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
            if (i + 1 < length && s.charAt(i) == s.charAt(i + 1)) {
                if (longestLength < 2) {
                    longestLength = 2;
                    longestStart = i;
                }
                dp[i][i + 1] = true;
            }
        }
        for (int subLength = 3; subLength <= length; subLength++) {
            for (int start = 0; start <= length - subLength; start++) {
                if (start + subLength > length) {
                    break;
                }
                dp[start][start + subLength - 1] = dp[start + 1][start + subLength - 2]
                                                   && (s.charAt(start) == s.charAt(start + subLength - 1));
                if (dp[start][start + subLength - 1] && subLength > longestLength) {
                    longestStart = start;
                    longestLength = subLength;
                }
            }
        }
        return s.substring(longestStart, longestStart + longestLength);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "cbbbbd";
        System.out.println(s.longestPalindrome(str));
    }
}