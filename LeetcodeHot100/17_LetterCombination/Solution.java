import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, String> digitMap = new HashMap<>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }
        };
        List<String> result = new ArrayList<>();
        StringBuilder combination = new StringBuilder();
        helper(digits, 0, result, digitMap, combination);
        return result;
    }

    private void helper(String digits, int index, List<String> result,
                        Map<Character, String> digitMap, StringBuilder combination) {
        if (index >= digits.length()) {
            result.add(combination.toString());
            return;
        }
        String letters = digitMap.get(digits.charAt(index));
        for (int i = 0; i < letters.length(); i++) {
            combination.append(letters.charAt(i));
            helper(digits, index + 1, result, digitMap, combination);
            combination.deleteCharAt(index);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> result = s.letterCombinations("23");
        for (String str : result) {
            System.out.print(str + " ");
        }
    }
}