import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int right = 0;
        Set<Character> characters = new HashSet<>();
        int longest = 0;
        for (int left = 0; left < s.length(); left++) {
            while (right < s.length() && !characters.contains(s.charAt(right))) {
                characters.add(s.charAt(right));
                right += 1;
            }
            longest = Math.max(longest, right - left);
            characters.remove(s.charAt(left));
        }
        return longest;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("1"));
    }
}