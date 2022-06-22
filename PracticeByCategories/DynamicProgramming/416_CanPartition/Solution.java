class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i <= target; i++) {
            dp[i] = nums[0] == i;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                if (j - nums[i] >= 0) {
                    dp[j] |= dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5};
        Solution solution = new Solution();
        System.out.println(solution.canPartition(nums));
    }
}