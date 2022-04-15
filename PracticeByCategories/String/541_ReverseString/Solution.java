class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (true) {
            for (int i = k - 1; i >= 0; i--) {
                if (index + i < s.length()) {
                    sb.append(s.charAt(index + i));
                }
            }
            index += k;
            for (int i = 0; i < k; i++) {
                if (index + i >= s.length()) {
                    return sb.toString();
                }
                sb.append(s.charAt(index + i));
            }
            index += k;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "abcdefg";
        System.out.println(s.reverseStr(str, 2));
    }
}