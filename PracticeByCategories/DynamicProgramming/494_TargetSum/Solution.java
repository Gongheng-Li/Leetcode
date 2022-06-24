class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum - target < 0 || (sum - target) % 2 == 1) {
            return 0;
        }
        target = (sum - target) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        if (nums[0] <= target) {
            dp[nums[0]] += 1;
        }
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            for (int j = target; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {7, 9, 3, 8, 0, 2, 4, 3, 8, 9};
        Solution solution = new Solution();
        System.out.println(solution.findTargetSumWays(nums, 0));
    }
}