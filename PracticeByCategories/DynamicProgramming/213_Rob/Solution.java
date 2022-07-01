class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int prev = 0, curr = 0;
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = Math.max(curr, prev + nums[i]);
            prev = curr;
            curr = temp;
        }
        max = curr;
        prev = 0;
        curr = 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = Math.max(curr, prev + nums[i]);
            prev = curr;
            curr = temp;
        }
        max = Math.max(max, curr);
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {2, 3, 2};
        int[] nums = {1};
        System.out.println(solution.rob(nums));
    }
}