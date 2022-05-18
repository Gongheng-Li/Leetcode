import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> partition(String s) {
        int sLength = s.length();
        boolean[][] isPalindrome = new boolean[sLength][sLength];
        for (int i = 0; i < sLength - 1; i++) {
            isPalindrome[i][i] = true;
            isPalindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }
        isPalindrome[sLength - 1][sLength - 1] = true;
        for (int length = 2; length < sLength; length++) {
            for (int i = 0; i < sLength - length; i++) {
                isPalindrome[i][i + length] = s.charAt(i) == s.charAt(i + length) && isPalindrome[i + 1][i + length - 1];
            }
        }
        List<String> combination = new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        partition(s, 0, combination, result, isPalindrome);
        return result;
    }

    private void partition(String s, int start, List<String> combination, List<List<String>> result, boolean[][] isPalindrome) {
        if (start == s.length()) {
            result.add(List.copyOf(combination));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome[start][i]) {
                combination.add(s.substring(start, i + 1));
                partition(s, i + 1, combination, result, isPalindrome);
                combination.remove(combination.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.partition("cbbbcc"));
    }
}