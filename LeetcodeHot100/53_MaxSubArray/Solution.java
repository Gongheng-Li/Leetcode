class Solution {
    public int maxSubArray(int[] nums) {
        int maxEndsWithThis = 0;
        int maxSubArraySum = Integer.MIN_VALUE;
        for (int num : nums) {
            maxEndsWithThis = Math.max(num, maxEndsWithThis + num);
            maxSubArraySum = Math.max(maxEndsWithThis, maxSubArraySum);
        }
        return maxSubArraySum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution s = new Solution();
        System.out.println(s.maxSubArray(nums));
    }
}