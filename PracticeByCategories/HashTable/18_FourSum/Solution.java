import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 3) {
            int j = i + 1;
            while (j < nums.length - 2) {
                if (nums[i] + nums[j] > target && nums[j + 1] > 0) {
                    break;
                }
                int m = j + 1, n = nums.length - 1;
                int refreshedTarget = target - nums[i] - nums[j];
                while (m < n) {
                    if (nums[m] + nums[n] < refreshedTarget) {
                        m = skipRepeatForward(nums, m);
                    } else if (nums[m] + nums[n] > refreshedTarget) {
                        n = skipRepeatBackward(nums, n);
                    } else {
                        List<Integer> tuple = new ArrayList<>();
                        tuple.add(nums[i]);
                        tuple.add(nums[j]);
                        tuple.add(nums[m]);
                        tuple.add(nums[n]);
                        result.add(tuple);
                        m = skipRepeatForward(nums, m);
                        n = skipRepeatBackward(nums, n);
                    }
                }
                j = skipRepeatForward(nums, j);
            }
            i = skipRepeatForward(nums, i);
        }
        return result;
    }

    private int skipRepeatForward(int[] nums, int k) {
        while (k + 1 < nums.length && nums[k + 1] == nums[k]) {
            k += 1;
        }
        return k + 1;
    }

    private int skipRepeatBackward(int[] nums, int k) {
        while (k - 1 >= 0 && nums[k - 1] == nums[k]) {
            k -= 1;
        }
        return k - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, -2, -5, -4, -3, 3, 3, 5};
        System.out.println(s.fourSum(nums, -11));
    }
}