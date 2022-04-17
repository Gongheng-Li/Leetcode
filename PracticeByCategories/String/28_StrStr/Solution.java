class Solution {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        int hayLength = haystack.length(), needleLength = needle.length();
        char beginChar = needle.charAt(0);
        for (int i = 0; i <= hayLength - needleLength; i++) {
            if (haystack.charAt(i) == beginChar && needle.equals(haystack.substring(i, i + needleLength))) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.strStr("a", "a"));
    }
}