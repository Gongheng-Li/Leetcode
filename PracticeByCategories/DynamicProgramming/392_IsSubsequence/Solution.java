class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        if (s.length() == t.length()) {
            return s.equals(t);
        }
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            char sChar = s.charAt(i);
            while (t.charAt(j) != sChar) {
                j += 1;
                if (j >= t.length()) {
                    return false;
                }
            }
            i += 1;
            j += 1;
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSubsequence("acb", "ahbgdc"));
    }
}