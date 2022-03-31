class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right -= 1;
            } else {
                left += 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3, 2, 2, 3};
        System.out.println(s.removeElement(nums, 3));
    }
}