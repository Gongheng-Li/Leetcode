import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i % k == 0) {
                prefix[i] = nums[i];
            } else {
                prefix[i] = Math.max(nums[i], prefix[i - 1]);
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                suffix[i] = nums[i];
            } else if ((i + 1) % k == 0) {
                suffix[i] = nums[i];
            } else {
                suffix[i] = Math.max(suffix[i + 1], nums[i]);
            }
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = Math.max(prefix[i + k - 1], suffix[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.maxSlidingWindow(nums, 3)));
    }
}