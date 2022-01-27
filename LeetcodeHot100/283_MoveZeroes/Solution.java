import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public void moveZeroes(int[] nums) {
        int wind = 0, forest = 0;
        while (wind < nums.length) {
            while (wind < nums.length && nums[wind] == 0) {
                wind += 1;
            }
            if (wind < nums.length) {
                swap(nums, wind, forest);
                wind += 1;
                forest += 1;
            }
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        Solution s = new Solution();
        s.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}