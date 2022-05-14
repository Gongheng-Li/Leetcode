import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        List[] map = new List[8];
        char ch = 'a';
        for (int i = 2; i <= 9; i++) {
            List<Character> characters = new ArrayList<>();
            if (i == 7 || i == 9) {
                for (int j = 0; j < 4; j++) {
                    characters.add(ch++);
                }
            } else {
                for (int j = 0; j < 3; j++) {
                    characters.add(ch++);
                }
            }
            map[i - 2] = characters;
        }
        StringBuilder sb = new StringBuilder();
        List<String> result = new ArrayList<>();
        combine(digits, 0, sb, map, result);
        return result;
    }

    private void combine(String digits, int index, StringBuilder sb, List[] map, List<String> result) {
        if (index >= digits.length()) {
            return;
        }
        int button = digits.charAt(index) - '0';
        List<Character> characters = (List<Character>) map[button - 2];
        for (char ch : characters) {
            sb.append(ch);
            if (index + 1 == digits.length()) {
                result.add(sb.toString());
            } else {
                combine(digits, index + 1, sb, map, result);
            }
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.letterCombinations(""));
    }
}