import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int sLength = s.length();
        boolean[] dp = new boolean[sLength + 1];
        dp[0] = true;
        for (int i = 1; i <= sLength; i++) {
            for (String word : wordDict) {
                if (i >= word.length()) {
                    if (matchEnd(s, i, word)) {
                        dp[i] |= dp[i - word.length()];
                    }
                }
            }
        }
        return dp[sLength];
    }

    private boolean matchEnd(String s, int end, String pattern) {
        for (int i = end - 1, j = pattern.length() - 1; j >= 0; i--, j--) {
            if (pattern.charAt(j) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        List<String> wordDict = List.of("leet", "code");
//        List<String> wordDict = List.of("apple", "pen");
        List<String> wordDict = List.of("cats", "dog", "sand", "and", "cat");
        Solution solution = new Solution();
        System.out.println(solution.wordBreak("catsandog", wordDict));
    }
}