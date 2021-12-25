class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int maxByThis = Integer.MIN_VALUE;
        int minByThis = Integer.MAX_VALUE;
        int leftEnd = -1, rightEnd = -1;
        for (int i = 0; i < nums.length; i++) {
            if (maxByThis > nums[i]) {
                rightEnd = i;
            } else {
                maxByThis = nums[i];
            }
            if (minByThis < nums[nums.length - 1 - i]) {
                leftEnd = nums.length - 1 - i;
            } else {
                minByThis = nums[nums.length - 1 - i];
            }
        }
        if (leftEnd == -1) {
            return 0;
        } else {
            return rightEnd - leftEnd + 1;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        Solution s = new Solution();
        System.out.println(s.findUnsortedSubarray(nums));
    }
}