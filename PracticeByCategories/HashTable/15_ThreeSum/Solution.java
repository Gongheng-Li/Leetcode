import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int k = 0;
        while (k < nums.length) {
            if (nums[k] > 0) {
                break;
            }
            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                if (nums[k] + nums[i] + nums[j] < 0) {
                    i = skipRepeatForward(nums, i);
                } else if (nums[k] + nums[i] + nums[j] > 0) {
                    j = skipRepeatBackward(nums, j);
                } else {
                    List<Integer> lst = new ArrayList<>();
                    lst.add(nums[k]);
                    lst.add(nums[i]);
                    lst.add(nums[j]);
                    result.add(lst);
                    i = skipRepeatForward(nums, i);
                    j = skipRepeatBackward(nums, j);
                }
            }
            k = skipRepeatForward(nums, k);
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

    private void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        Random random = new Random();
        int middle = start + random.nextInt(end - start + 1);
        swap(nums, start, middle);
        int left = start + 1, right = end;
        while (true) {
            while (nums[left] < nums[start] && left < end) {
                left += 1;
            }
            while (nums[right] > nums[start] && right > start) {
                right -= 1;
            }
            if (left >= right) {
                break;
            }
            swap(nums, left, right);
            left += 1;
            right -= 1;
        }
        swap(nums, start, right);
        sort(nums, start, right - 1);
        sort(nums, right + 1, end);
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        Solution s = new Solution();
//        s.sort(nums);
        System.out.println(s.threeSum(nums));
    }
}