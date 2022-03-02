class Solution {
    public String minWindow(String s, String t) {
        int[] target = new int[128];
        int[] current = new int[128];
        int sLength = s.length(), tLength = t.length();
        for (int i = 0; i < tLength; i++) {
            target[t.charAt(i)] += 1;
        }
        int minStart = 0, minLength = -1;
        int count = 0;
        int left = 0, right = 0;
        while (right < sLength) {
            char rightChar = s.charAt(right);
            if (target[rightChar] > 0) {
                current[rightChar] += 1;
                if (target[rightChar] >= current[rightChar]) {
                    count += 1;
                }
                while (count == tLength) {
                    if (right - left < minLength || minLength == -1) {
                        minLength = right - left;
                        minStart = left;
                    }
                    char leftChar = s.charAt(left);
                    if (target[leftChar] > 0) {
                        if (target[leftChar] >= current[leftChar]) {
                            count -= 1;
                        }
                        current[leftChar] -= 1;
                    }
                    left += 1;
                }
            }
            right += 1;
        }
        return s.substring(minStart, minStart + minLength + 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minWindow("ADOBECODEBANC", "ABC"));
    }
}