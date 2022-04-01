class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int sum = 0;
        int minLength = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                sum -= nums[left];
                left += 1;
            }
            right += 1;
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2, 3, 1, 2, 4, 3};
//        int[] nums = {1, 4, 4};
//        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(s.minSubArrayLen(7, nums));
    }
}