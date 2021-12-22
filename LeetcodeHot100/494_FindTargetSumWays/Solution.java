class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < target || (sum - target) % 2 != 0) {
            return 0;
        }
        int negativeSum = (sum - target) / 2;
        int[] dp = new int[negativeSum + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = negativeSum; j >= num; j--) {
                dp[j] = dp[j] + dp[j - num];
            }
        }
        return dp[negativeSum];
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 1};
        Solution s = new Solution();
        System.out.println(s.findTargetSumWays(nums, 1));
    }
}