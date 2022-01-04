import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        Set<Character> characters = new HashSet<>();
        int longest = 0;
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (characters.contains(ch)) {
                while (s.charAt(left) != ch) {
                    characters.remove(s.charAt(left));
                    left += 1;
                }
                left += 1;
            } else {
                characters.add(ch);
            }
            longest = Math.max(longest, right - left + 1);
            right += 1;
        }
        return longest;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
    }
}