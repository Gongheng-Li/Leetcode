class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int maxRange = 0;
        int end = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i + nums[i] >= nums.length) {
                return result + 1;
            }
            maxRange = Math.max(maxRange, i + nums[i]);
            if (i == end) {
                end = maxRange;
                result += 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 3, 4};
        Solution solution = new Solution();
        System.out.println(solution.jump(nums));
    }
}