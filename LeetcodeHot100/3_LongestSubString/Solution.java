import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> substring = new LinkedList<>();
        Set<Character> characters = new HashSet<>();
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (characters.contains(ch)) {
                while (!substring.isEmpty() && substring.peek() != ch) {
                    char chInsideDuplicate = substring.poll();
                    characters.remove(chInsideDuplicate);
                }
                substring.poll();
            } else {
                characters.add(ch);
            }
            substring.add(ch);
            if (substring.size() > longest) {
                longest = substring.size();
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring(""));
    }
}