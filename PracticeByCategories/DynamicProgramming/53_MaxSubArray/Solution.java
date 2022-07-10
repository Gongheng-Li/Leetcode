class Solution {
    public int maxSubArray(int[] nums) {
        int pioneer = 0, tail = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        while (pioneer < nums.length) {
            while (sum >= 0 && pioneer < nums.length) {
                sum += nums[pioneer];
                maxSum = Math.max(maxSum, sum);
                pioneer += 1;
            }
            while (sum < 0 && tail < pioneer) {
                sum -= nums[tail];
                tail += 1;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = {5, 4, -1, 7, 8};
        int[] nums = {-1};
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(nums));
    }
}