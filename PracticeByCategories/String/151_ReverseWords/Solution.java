class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int index = s.length() - 1;
        while (index >= 0) {
            while (index >= 0 && s.charAt(index) == ' ') {
                index -= 1;
            }
            int end = index;
            while (index >= 0 && s.charAt(index) != ' ') {
                index -= 1;
            }
            sb.append(s, index + 1, end + 1);
            sb.append(' ');
        }
        while (sb.charAt(sb.length() - 1) == ' ') {
            sb.delete(sb.length() - 1, sb.length());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseWords("  the sky is  blue "));
    }
}