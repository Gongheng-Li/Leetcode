class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int minPrefix = 0;
        int maxSubArraySum = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            maxSubArraySum = Math.max(sum - minPrefix, maxSubArraySum);
            minPrefix = Math.min(sum, minPrefix);
        }
        return maxSubArraySum;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        Solution s = new Solution();
        System.out.println(s.maxSubArray(nums));
    }
}