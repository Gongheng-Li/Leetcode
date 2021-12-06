class Solution {
    public void nextPermutation(int[] nums) {
        int reverseStart = 0;
        int left = 0, right = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                left = i;
                reverseStart = i + 1;
                break;
            }
        }
        for (int j = nums.length - 1; j > left; j--) {
            if (nums[j] > nums[left]) {
                right = j;
                break;
            }
        }
        swap(nums, left, right);
        for (int i = reverseStart; i <= (reverseStart + nums.length - 1) / 2; i++) {
            swap(nums, i, nums.length - 1 + reverseStart - i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3};
        Solution s = new Solution();
        s.nextPermutation(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}