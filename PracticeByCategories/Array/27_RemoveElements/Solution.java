class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        while (i < nums.length) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j += 1;
            }
            i += 1;
        }
        return j;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3, 2, 2, 3};
        System.out.println(s.removeElement(nums, 2));
    }
}