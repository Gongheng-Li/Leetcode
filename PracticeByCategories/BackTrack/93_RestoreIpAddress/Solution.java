import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        split(s, 0, sb, result, 4);
        return result;
    }

    private void split(String s, int start, StringBuilder sb, List<String> result, int expectedCount) {
        if (expectedCount == 0 && start == s.length()) {
            result.add(sb.toString());
            return;
        }
        if (s.length() - start < expectedCount || s.length() - start > 3 * expectedCount) {
            return;
        }
        if (sb.length() != 0) {
            sb.append('.');
        }
        sb.append(s.charAt(start));
        split(s, start + 1, sb, result, expectedCount - 1);
        sb.delete(sb.length() - 1, sb.length());
        if (start + 1 < s.length() && s.charAt(start) != '0') {
            sb.append(s, start, start + 2);
            split(s, start + 2, sb, result, expectedCount - 1);
            sb.delete(sb.length() - 2, sb.length());
        }
        if (start + 2 < s.length() && isValid(s, start)) {
            sb.append(s, start, start + 3);
            split(s, start + 3, sb, result, expectedCount - 1);
            sb.delete(sb.length() - 3, sb.length());
        }
        if (sb.length() != 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private boolean isValid(String s, int start) {
        return s.charAt(start) != '0' && (s.charAt(start) < '2' || s.charAt(start) == '2' && s.charAt(start + 1) < '5' ||
                s.charAt(start) == '2' && s.charAt(start + 1) == '5' && s.charAt(start + 2) <= '5');
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.restoreIpAddresses("101023"));
    }
}