class Solution {
    public boolean repeatedSubstringPattern(String s) {
        s = " " + s;
        char[] sArray = s.toCharArray();
        int[] next = new int[sArray.length];
        for (int j = 0, i = 2; i < sArray.length; i++){
            while (j != 0 && sArray[i] != sArray[j + 1]) {
                j = next[j];
            }
            if (sArray[i] == sArray[j + 1]) {
                j += 1;
            }
            next[i] = j;
            if (next[i] < next[i - 1] || next[i] == next[i - 1] && next[i] != 0) {
                return false;
            }
        }
        return next[next.length - 1] % (next.length - next[next.length - 1] - 1) == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.repeatedSubstringPattern("a"));
    }
}