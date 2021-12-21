import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int[] sCharacters = new int[26];
        int[] pCharacters = new int[26];
        for (int i = 0; i < p.length(); i++) {
            sCharacters[s.charAt(i) - 'a'] += 1;
            pCharacters[p.charAt(i) - 'a'] += 1;
        }
        if (Arrays.equals(sCharacters, pCharacters)) {
            result.add(0);
        }
        for (int i = 1; i <= s.length() - p.length(); i++) {
            sCharacters[s.charAt(i - 1) - 'a'] -= 1;
            sCharacters[s.charAt(i + p.length() - 1) - 'a'] += 1;
            if (Arrays.equals(sCharacters, pCharacters)) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findAnagrams("aaaa", "aaaaa"));
    }
}