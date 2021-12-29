class Solution {
    public int countSubstrings(String s) {
        StringBuilder manacherString = new StringBuilder("$#");
        for (int i = 0; i < s.length(); i++) {
            manacherString.append(s.charAt(i));
            manacherString.append('#');
        }
        manacherString.append('!');
        int rightMost = 0;
        int centerOfRightMost = 0;
        int sum = 0;
        int[] radius = new int[2 * s.length() + 1];
        for (int i = 0; i < 2 * s.length() + 1; i++) {
            radius[i] = 1;
            if (i < rightMost) {
                radius[i] = Math.min(rightMost - i + 1, radius[centerOfRightMost * 2 - i]);
            }
            while (manacherString.charAt(i - radius[i] + 1 + 1) == manacherString.charAt(i + radius[i] - 1 + 1)) {
                radius[i] += 1;
            }
            radius[i] -= 1;
            sum += radius[i] / 2;
            if (i + radius[i] - 1 > rightMost) {
                rightMost = i + radius[i] - 1;
                centerOfRightMost = i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countSubstrings("aaaa"));
    }
}