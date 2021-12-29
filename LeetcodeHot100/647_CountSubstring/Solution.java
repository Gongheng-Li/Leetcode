class Solution {
    public int countSubstrings(String s) {
        int sum = 0;
        for (int i = 0; i < 2 * s.length() - 1; i++) {
            int left = i / 2, right = i / 2 + i % 2;
            while (left >= 0 && right < s.length()) {
                if (s.charAt(left) == s.charAt(right)) {
                    sum += 1;
                } else {
                    break;
                }
                left -= 1;
                right += 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countSubstrings("aaa"));
    }
}