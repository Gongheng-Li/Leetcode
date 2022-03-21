import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int leftToRemove = 0, rightToRemove = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftToRemove += 1;
            } else if (s.charAt(i) == ')') {
                if (leftToRemove > 0) {
                    leftToRemove -= 1;
                } else {
                    rightToRemove += 1;
                }
            }
        }
        List<String> result = new ArrayList<>();
        helper(s, 0, leftToRemove, rightToRemove, result);
        return result;
    }

    private void helper(String s, int start, int leftToRemove, int rightToRemove, List<String> result) {
        if (leftToRemove == 0 && rightToRemove == 0) {
            if (checkValid(s)) {
                result.add(s);
                return;
            }
        } else if (leftToRemove + rightToRemove > s.length() - start) {
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (i != start && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }
            if (leftToRemove > 0 && s.charAt(i) == '(') {
                helper(s.substring(0, i) + s.substring(i + 1), i, leftToRemove - 1, rightToRemove, result);
            } else if (rightToRemove > 0 && s.charAt(i) == ')') {
                helper(s.substring(0, i) + s.substring(i + 1), i, leftToRemove, rightToRemove - 1, result);
            }
        }
    }

    private boolean checkValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count += 1;
            } else if (s.charAt(i) == ')') {
                if (count <= 0) {
                    return false;
                }
                count -= 1;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeInvalidParentheses(")("));
    }
}