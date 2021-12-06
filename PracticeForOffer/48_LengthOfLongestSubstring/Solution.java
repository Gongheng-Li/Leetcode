import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int maxLength = 0;
        int left = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (lastSeen.containsKey(ch)) {
                left = Math.max(lastSeen.get(ch), left);
            }
            maxLength = Math.max(i - left, maxLength);
            lastSeen.put(ch, i);
        }
        return maxLength;
    }
}