class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int longest = 1, currLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currLength += 1;
                longest = Math.max(longest, currLength);
            } else {
                currLength = 1;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {1, 3, 5, 4, 7};
        int[] nums = {2, 2, 2, 2, 2};
        System.out.println(solution.findLengthOfLCIS(nums));
    }
}