class Solution {
    public boolean canJump(int[] nums) {
        int farthest = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] >= farthest - i) {
                farthest = i;
            }
        }
        return farthest == 0;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        Solution s = new Solution();
        System.out.println(s.canJump(nums));
    }
}