class Solution {
    public int maxSubArray(int[] nums) {
        int ptr = 0;
        int max = Integer.MIN_VALUE;
        int tempSum = 0;
        while (ptr < nums.length) {
            tempSum += nums[ptr];
            if (tempSum > max) {
                max = tempSum;
            }
            if (tempSum < 0) {
                tempSum = 0;
            }
            ptr += 1;
        }
        return max;
    }
}