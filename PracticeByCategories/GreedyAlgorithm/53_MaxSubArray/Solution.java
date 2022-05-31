class Solution {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int subArraySum = 0;
        for (int num : nums) {
            subArraySum += num;
            result = Math.max(result, subArraySum);
            if (subArraySum < 0) {
                subArraySum = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(nums));
    }
}