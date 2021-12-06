class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int[] result = new int[2];
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                result[0] = nums[left];
                result[1] = nums[right];
                break;
            } else if (nums[left] + nums[right] > target) {
                right -= 1;
            } else {
                left += 1;
            }
        }
        return result;
    }
}