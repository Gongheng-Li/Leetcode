class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int leftEnd = 0, rightEnd = 0;
        int[] extreme = new int[nums.length];
        extreme[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            extreme[i] = Math.max(nums[i], extreme[i - 1]);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (extreme[i] != nums[i]) {
                rightEnd = i;
                break;
            }
        }
        extreme[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            extreme[i] = Math.min(nums[i], extreme[i + 1]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (extreme[i] != nums[i]) {
                leftEnd = i;
                break;
            }
        }
        if (leftEnd < rightEnd) {
            return rightEnd - leftEnd + 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        Solution s = new Solution();
        System.out.println(s.findUnsortedSubarray(nums));
    }
}