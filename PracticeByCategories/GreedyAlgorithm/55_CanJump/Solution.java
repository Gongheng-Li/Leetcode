class Solution {
    public boolean canJump(int[] nums) {
        int rightMost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > rightMost) {
                return false;
            }
            if (i + nums[i] > rightMost) {
                rightMost = i + nums[i];
            }
            if (rightMost >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }
}