class Solution {
    public int monotoneIncreasingDigits(int n) {
        if (n < 10) {
            return n;
        }
        String digits = Integer.toString(n);
        int digitLength = digits.length();
        int[] result = new int[digitLength];
        for (int i = 0; i < digitLength - 1; i++) {
            if (digits.charAt(i) <= digits.charAt(i + 1)) {
                result[i] = digits.charAt(i) - '0';
                result[i + 1] = digits.charAt(i + 1) - '0';
            } else {
                for (int j = i + 1; j < digitLength; j++) {
                    result[j] = 9;
                }
                int j = i;
                while (j > 0 && digits.charAt(j) == digits.charAt(j - 1)) {
                    result[j] = 9;
                    j -= 1;
                }
                result[j] = digits.charAt(j) - '0' - 1;
                break;
            }
        }
        int resultNum = 0;
        for (int digit : result) {
            resultNum = resultNum * 10 + digit;
        }
        return resultNum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.monotoneIncreasingDigits(372846));
    }
}