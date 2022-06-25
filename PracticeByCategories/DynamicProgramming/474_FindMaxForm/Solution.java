class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int zeroCount0 = countDigit(strs[0]);
        for (int i = zeroCount0; i <= m; i++) {
            for (int j = strs[0].length() - zeroCount0; j <= n; j++) {
                dp[i][j] = 1;
            }
        }
        for (int i = 1; i < strs.length; i++) {
            int zeroCount = countDigit(strs[i]), oneCount = strs[i].length() - zeroCount;
            for (int j = m; j >= zeroCount; j--) {
                for (int k = n; k >= oneCount; k--) {
                    dp[j][k] = Math.max(dp[j][k], 1 + dp[j - zeroCount][k - oneCount]);
                }
            }
        }
        return dp[m][n];
    }

    private int countDigit(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        String[] strs = {"10", "0001", "111001", "1", "0"};
        String[] strs = {"10", "1", "0"};
        Solution solution = new Solution();
        System.out.println(solution.findMaxForm(strs, 1, 1));
    }
}