class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        int minLength = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int thisTarget = i == 0?target:nums[i - 1] + target;
            if (thisTarget > nums[nums.length - 1]) {
                break;
            }
            int left = i, right = nums.length - 1;
            while (left <= right) {
                int middle = (left + right) / 2;
                if (nums[middle] >= thisTarget) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            minLength = Math.min(minLength, left - i + 1);
        }
        return minLength==Integer.MAX_VALUE?0:minLength;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2, 3, 1, 2, 4, 3};
//        int[] nums = {1, 4, 4};
//        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(s.minSubArrayLen(7, nums));
    }
}