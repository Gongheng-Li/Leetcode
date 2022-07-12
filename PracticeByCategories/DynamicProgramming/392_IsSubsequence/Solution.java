class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        if (s.length() == t.length()) {
            return s.equals(t);
        }
        int sLength = s.length(), tLength = t.length();
        int[][] dp = new int[tLength + 1][26];
        for (int i = 0; i < 26; i++) {
            dp[tLength][i] = -1;
        }
        for (int i = tLength - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a') {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        int index = 0;
        for (int i = 0; i < sLength; i++) {
            if (dp[index][s.charAt(i) - 'a'] == -1) {
                return false;
            }
            index = dp[index][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSubsequence("acb", "ahbgdc"));
    }
}