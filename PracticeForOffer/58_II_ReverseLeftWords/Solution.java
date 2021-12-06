class Solution {
    public String reverseLeftWords(String s, int n) {
        StringBuilder result = new StringBuilder();
        result.append(s.substring(n));
        result.append(s.substring(0, n));
        return result.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseLeftWords("abcdefg", 2));
    }
}