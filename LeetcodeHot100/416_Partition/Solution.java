class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0 || maxNum > sum / 2) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
//        if (nums[0] <= target) {     // This statement is no longer needed because the loop below starts from i == 0.
//            dp[nums[0]] = true;
//        }
        for (int num : nums) {
            for (int j = target; j >= num; j--) { // The elements before nums[i] are the same as the last row.
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        Solution s = new Solution();
        System.out.println(s.canPartition(nums));
    }
}