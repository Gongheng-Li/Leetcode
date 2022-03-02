import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> current = new HashMap<>();
        Map<Character, Integer> target = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            target.put(ch, target.getOrDefault(ch, 0) + 1);
        }
        int left = 0, right = 0;
        int minLeft = 0, minRight = -1;
        while (right < s.length()) {
            char rightCh = s.charAt(right);
            current.put(rightCh, current.getOrDefault(rightCh, 0) + 1);
            if (contains(current, target)) {
                while (left <= right) {
                    char leftCh = s.charAt(left);
                    if (current.get(leftCh) - 1 > 0) {
                        current.put(leftCh, current.get(leftCh) - 1);
                    } else {
                        current.remove(leftCh);
                    }
                    if (!contains(current, target)) {
                        if (right - left < minRight - minLeft || minRight == -1) {
                            minLeft = left;
                            minRight = right;
                        }
                        left += 1;
                        break;
                    }
                    left += 1;
                }
            }
            right += 1;
        }
        return s.substring(minLeft, minRight + 1);
    }

    private boolean contains(Map<Character, Integer> current, Map<Character, Integer> target) {
        for (char key : target.keySet()) {
            if (!current.containsKey(key) || current.get(key) < target.get(key)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minWindow("a", "aa"));
    }
}