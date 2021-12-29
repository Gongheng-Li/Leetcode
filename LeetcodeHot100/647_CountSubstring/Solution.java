class Solution {
    public int countSubstrings(String s) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        dp[1] = true;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j >= 2; j--) {
                dp[j] = dp[j - 2] && (s.charAt(i) == s.charAt(i - j + 1));
                if (dp[j]) {
                    sum += 1;
                }
            }
            sum += 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countSubstrings("aaa"));
    }
}