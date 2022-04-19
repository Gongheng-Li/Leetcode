class Solution {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        haystack = " " + haystack;
        needle = " " + needle;
        char[] haystackArray = haystack.toCharArray();
        char[] needleArray = needle.toCharArray();
        int[] next = new int[needleArray.length];
        for (int j = 0, i = 2; i < needleArray.length; i++) {
            while (j > 0 && needleArray[i] != needleArray[j + 1]) {
                j = next[j];
            }
            if (needleArray[i] == needleArray[j + 1]) {
                j += 1;
            }
            next[i] = j;
        }
        for (int j = 0, i = 1; i < haystackArray.length; i++) {
            while (j > 0 && haystackArray[i] != needleArray[j + 1]) {
                j = next[j];
            }
            if (haystackArray[i] == needleArray[j + 1]) {
                j += 1;
            }
            if (j == needleArray.length - 1) {
//                return i - needle.length();
                return i - needleArray.length + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.strStr("abcdefg", "cdfcdfcdf"));
    }
}