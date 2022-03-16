import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        suffix[nums.length - 1] = nums[nums.length - 1];
        for (int i = 0; i < nums.length; i++) {
            if (i % k == 0) {
                prefix[i] = nums[i];
            } else {
                prefix[i] = Math.max(prefix[i - 1], nums[i]);
            }
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if ((i + 1) % k == 0) {
                suffix[i] = nums[i];
            } else {
                suffix[i] = Math.max(suffix[i + 1], nums[i]);
            }
        }
        int[] max = new int[nums.length - k + 1];
        for (int i = 0; i < max.length; i++) {
            max[i] = Math.max(prefix[i + k - 1], suffix[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {9, 10, 9, -7, -4, -8, 2, -6};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.maxSlidingWindow(nums, 5)));
    }
}