import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] square = new int[nums.length];
        int left = 0, right = nums.length - 1;
        int index = nums.length - 1;
        while (left <= right) {
            if (Math.abs(nums[left]) < Math.abs(nums[right])) {
                square[index] = nums[right] * nums[right];
                right -= 1;
            } else {
                square[index] = nums[left] * nums[left];
                left += 1;
            }
            index -= 1;
        }
        return square;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.sortedSquares(nums)));
    }
}