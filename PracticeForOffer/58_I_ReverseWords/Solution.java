import java.util.Stack;

class Solution {
    public String reverseWords(String s) {
        int i = 0;
        StringBuilder resultBuilder = new StringBuilder();
        Stack<StringBuilder> sentence = new Stack<>();
        while (i < s.length()) {
            while (i < s.length() && s.charAt(i) == ' ') {
                i += 1;
            }
            StringBuilder word = new StringBuilder();
            while (i < s.length() && s.charAt(i) != ' ') {
                word.append(s.charAt(i));
                i += 1;
            }
            if (word.length() > 0) {
                sentence.push(word);
            }
        }
        while (!sentence.isEmpty()) {
            resultBuilder.append(sentence.pop());
            if (!sentence.isEmpty()) {
                resultBuilder.append(' ');
            }
        }
        return resultBuilder.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseWords("  hello world!  "));
    }
}