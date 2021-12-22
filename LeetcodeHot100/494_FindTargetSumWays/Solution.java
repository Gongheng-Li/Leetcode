class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < target || (sum - target) % 2 == 1) {
            return 0;
        }
        int negativeNumber = (sum - target) / 2;
        int[][] dp = new int[nums.length + 1][negativeNumber + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= negativeNumber; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][negativeNumber];
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 1};
        Solution s = new Solution();
        System.out.println(s.findTargetSumWays(nums, 1));
    }
}