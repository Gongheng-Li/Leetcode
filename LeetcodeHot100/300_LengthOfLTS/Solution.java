class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int longestLength = 1;
        for (int i = 1; i < dp.length; i++) {
            int longestLengthEndHere = 1;
            for (int j = i; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    longestLengthEndHere = Math.max(longestLengthEndHere, dp[j] + 1);
                }
            }
            dp[i] = longestLengthEndHere;
            longestLength = Math.max(longestLength, dp[i]);
        }
        return longestLength;
    }

    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 3, 3, 3};
        Solution s = new Solution();
        System.out.println(s.lengthOfLIS(nums));
    }
}