import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int leftToRemove = 0, rightToRemove = 0;
        List<Integer> leftPos = new ArrayList<>();
        List<Integer> rightPos = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftPos.add(i);
                leftToRemove += 1;
            } else if (s.charAt(i) == ')') {
                rightPos.add(i);
                if (leftToRemove > 0) {
                    leftToRemove -= 1;
                } else {
                    rightToRemove += 1;
                }
            }
        }
        List<Integer> leftMasks = new ArrayList<>();
        List<Integer> rightMasks = new ArrayList<>();
        int leftCount = leftPos.size(), rightCount = rightPos.size();
        for (int i = 0; i < (1 << leftCount); i++) {
            if (Integer.bitCount(i) == leftToRemove) {
                leftMasks.add(i);
            }
        }
        for (int i = 0; i < (1 << rightCount); i++) {
            if (Integer.bitCount(i) == rightToRemove) {
                rightMasks.add(i);
            }
        }
        Set<String> resultSet = new HashSet<>();
        for (int leftMask : leftMasks) {
            for (int rightMask : rightMasks) {
                if (checkValid(s, leftMask, rightMask, leftPos, rightPos)) {
                    resultSet.add(recoverString(s, leftMask, rightMask, leftPos, rightPos));
                }
            }
        }
        return new ArrayList<>(resultSet);
    }

    private boolean checkValid(String s, int leftMask, int rightMask, List<Integer> leftPos, List<Integer> rightPos) {
        int count = 0;
        int leftIndex = 0, rightIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (leftIndex < leftPos.size() && i == leftPos.get(leftIndex)) {
                if ((leftMask & (1 << leftIndex)) == 0) {
                    count += 1;
                }
                leftIndex += 1;
            } else if (rightIndex < rightPos.size() && i == rightPos.get(rightIndex)) {
                if ((rightMask & (1 << rightIndex)) == 0) {
                    if (count <= 0) {
                        return false;
                    } else {
                        count -= 1;
                    }
                }
                rightIndex += 1;
            }
        }
        return true;
    }

    private String recoverString (String s, int leftMask, int rightMask, List<Integer> leftPos, List<Integer> rightPos) {
        int leftIndex = 0, rightIndex = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (leftIndex < leftPos.size() && i == leftPos.get(leftIndex)) {
                if ((leftMask & (1 << leftIndex)) == 0) {
                    stringBuilder.append('(');
                }
                leftIndex += 1;
            } else if (rightIndex < rightPos.size() && i == rightPos.get(rightIndex)) {
                if ((rightMask & (1 << rightIndex)) == 0) {
                    stringBuilder.append(')');
                }
                rightIndex += 1;
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeInvalidParentheses("(a)())()"));
    }
}