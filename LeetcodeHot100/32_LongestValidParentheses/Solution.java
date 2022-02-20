import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        int longestLength = 0;
        int leftCount = 0, rightCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftCount += 1;
            } else {
                rightCount += 1;
            }
            if (leftCount == rightCount) {
                longestLength = Math.max(longestLength, 2 * leftCount);
            } else if (leftCount < rightCount) {
                leftCount = 0;
                rightCount = 0;
            }
        }
        leftCount = 0;
        rightCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                leftCount += 1;
            } else {
                rightCount += 1;
            }
            if (leftCount == rightCount) {
                longestLength = Math.max(longestLength, 2 * leftCount);
            } else if (leftCount > rightCount) {
                leftCount = 0;
                rightCount = 0;
            }
        }
        return longestLength;
    }

    public static void main(String[] args) {
        String parentheses = "(()";
        Solution s = new Solution();
        System.out.println(s.longestValidParentheses(parentheses));
    }
}