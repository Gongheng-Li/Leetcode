class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int maxValue = Math.max(nums[0], nums[1]);
        int maxByLast = maxValue, maxBySecondLast = nums[0], maxByThirdLast = 0;
        for (int i = 2; i < nums.length; i++) {
            int maxByThis = nums[i] + Math.max(maxBySecondLast, maxByThirdLast);
            maxValue = Math.max(maxValue, maxByThis);
            maxByThirdLast = maxBySecondLast;
            maxBySecondLast = maxByLast;
            maxByLast = maxByThis;
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        Solution s = new Solution();
        System.out.println(s.rob(nums));
    }
}