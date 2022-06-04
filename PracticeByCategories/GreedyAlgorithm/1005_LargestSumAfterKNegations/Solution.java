import java.util.Arrays;

class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int result = 0;
        int minAbs = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int i = 0;
        while (i < k) {
            if (i < nums.length && nums[i] < 0) {
                result -= nums[i];
                i += 1;
            } else {
                if (i < nums.length) {
                    minAbs = Math.abs(nums[i]);
                }
                if (i - 1 >= 0) {
                    minAbs = Math.min(minAbs, Math.abs(nums[i - 1]));
                }
                if ((k - i) % 2 == 1) {
                    result -= 2 * minAbs;
                }
                break;
            }
        }
        while (i < nums.length) {
            result += nums[i];
            i += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 3, -4, -6, -1};
        Solution solution = new Solution();
        System.out.println(solution.largestSumAfterKNegations(nums, 4));
    }
}