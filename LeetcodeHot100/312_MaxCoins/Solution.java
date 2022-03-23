import java.util.Arrays;

public class Solution {
    public int maxCoins(int[] nums) {
        int[] extendedNums = new int[nums.length + 2];
        extendedNums[0] = 1;
        extendedNums[extendedNums.length - 1] = 1;
        System.arraycopy(nums, 0, extendedNums, 1, nums.length);
        int[][] dp = new int[nums.length + 2][nums.length + 2];
        for (int length = 1; length <= nums.length; length++) {
            for (int i = 0; i < nums.length + 1; i++) {
                if (i + length >= nums.length + 1) {
                    continue;
                }
                int sum = 0;
                for (int j = i + 1; j < i + length + 1; j++) {
                    sum = Math.max(sum, extendedNums[j] * extendedNums[i] * extendedNums[i + length + 1]
                            + dp[i][j] + dp[j][i + length + 1]);
                }
                dp[i][i + length + 1] = sum;
            }
        }
        return dp[0][nums.length + 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3, 1, 5, 8};
        System.out.println(s.maxCoins(nums));
    }
}
