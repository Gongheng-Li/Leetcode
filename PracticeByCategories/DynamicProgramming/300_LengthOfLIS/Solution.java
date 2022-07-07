import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int maxLength = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(nums));
    }
}