class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int sLength = s.length();
        int[] next = new int[sLength];
        for (int i = 1, j = 0; i < sLength; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j += 1;
            }
            next[i] = j;
//            if (next[i] < next[i - 1] || next[i] != 0 && next[i] == next[i - 1]) {
//                return false;
//            }
        }
        return next[sLength - 1] != 0 && next[sLength - 1] % (sLength - next[sLength - 1]) == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.repeatedSubstringPattern("abcabdasd"));
    }
}