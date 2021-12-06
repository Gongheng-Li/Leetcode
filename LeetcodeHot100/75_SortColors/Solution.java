import java.util.Arrays;

class Solution {
    public void sortColors(int[] nums) {
        int zeroEnd = 0, oneEnd = 0;
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == 0) {
                swap(nums, zeroEnd, index);
                if (zeroEnd < oneEnd) {
                    swap(nums, oneEnd, index);
                }
                zeroEnd += 1;
                oneEnd += 1;
            } else if (nums[index] == 1) {
                swap(nums, oneEnd, index);
                oneEnd += 1;
            }
        }
    }

    private void swap(int[] nums, int index0, int index1) {
        int temp = nums[index0];
        nums[index0] = nums[index1];
        nums[index1] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        Solution s = new Solution();
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}