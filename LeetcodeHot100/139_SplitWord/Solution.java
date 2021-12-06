import java.util.*;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        Set<Integer> wordLength = new HashSet<>();
        for (String str : wordDict) {
            wordLength.add(str.length());
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int length : wordLength) {
                if (i - length >= 0 && dp[i - length] && wordSet.contains(s.substring(i - length, i))) {
                    dp[i] = true;
                    break;
                }
            }
//            for (int j = 0; j < i; j++) {
//                if (dp[j] && wordSet.contains(s.substring(j, i))) {
//                    dp[i] = true;
//                    break;
//                }
//            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
//        String[] wordArray = {"leet", "code"};
        List<String> wordDict = List.of("leet", "code");
        Solution s = new Solution();
        System.out.println(s.wordBreak("leetcode", wordDict));
    }
}