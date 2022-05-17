class Solution {
    public int countSubstrings(String s) {
        int rightMost = 0, rightMostCenter = 0;
        int sum = 1, length = s.length();
        int[] radius = new int[2 * length - 1];
        radius[0] = 1;
        for (int i = 1; i < 2 * length - 1; i++) {
            if ((i + 1) / 2 <= rightMost) {
                radius[i] = Math.min(rightMost - (i + 1) / 2 + 1, radius[2 * rightMostCenter - i]);
            } else {
                radius[i] = (i + 1) % 2;
            }
            int left = i / 2 - radius[i] + 1, right = (i + 1) / 2 + radius[i] - 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left -= 1;
                right += 1;
            }
            radius[i] = (right - left) / 2;
            sum += radius[i];
            if (right - 1 > rightMost) {
                rightMost = right - 1;
                rightMostCenter = i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countSubstrings("abaab"));
    }
}