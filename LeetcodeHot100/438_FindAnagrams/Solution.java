import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int[] count = new int[26];
        for (int i = 0; i < p.length(); i++) {
            count[s.charAt(i) - 'a'] += 1;
            count[p.charAt(i) - 'a'] -= 1;
        }
        int different = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                different += 1;
            }
        }
        if (different == 0) {
            result.add(0);
        }
        for (int i = 1; i <= s.length() - p.length(); i++) {
            int slideOut = s.charAt(i - 1) - 'a';
            if (count[slideOut] == 0) {
                different += 1;
            } else if (count[slideOut] == 1) {
                different -= 1;
            }
            count[slideOut] -= 1;
            int slideIn = s.charAt(i + p.length() - 1) - 'a';
            if (count[slideIn] == 0) {
                different += 1;
            } else if (count[slideIn] == -1) {
                different -= 1;
            }
            count[slideIn] += 1;
            if (different == 0) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findAnagrams("cbaebabacd", "abc"));
    }
}