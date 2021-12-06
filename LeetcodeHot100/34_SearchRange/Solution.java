class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        double leftTarget = target - 0.5, rightTarget = target + 0.5;
        int leftBoundary = searchBoundary(nums, leftTarget);
        if (nums[leftBoundary] != target) {
            leftBoundary += 1;
        }
        int rightBoundary = searchBoundary(nums, rightTarget);
        if (nums[rightBoundary] != target) {
            rightBoundary -= 1;
        }
        if (leftBoundary >= nums.length || nums[leftBoundary] != target) {
            leftBoundary = -1;
            rightBoundary = -1;
        }
        return new int[]{leftBoundary, rightBoundary};
    }
    private int searchBoundary(int[] nums, double target) {
        int begin = 0, end = nums.length - 1;
        while (begin < end) {
            int middle = (begin + end) / 2;
            if (nums[middle] > target) {
                end = middle - 1;
            } else {
                begin = middle + 1;
            }
        }
        return begin;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        Solution s = new Solution();
        int[] range = s.searchRange(nums, 6);
        for (int boundary : range) {
            System.out.print(boundary + " ");
        }
    }
}