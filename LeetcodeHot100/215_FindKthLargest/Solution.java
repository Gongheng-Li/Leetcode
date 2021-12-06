import java.util.Random;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int left = 0, right = nums.length - 1;
        Random random = new Random();
        while (left < right) {
            int partitionPoint = random.nextInt(right - left + 1) + left;
            swap(nums, left, partitionPoint);
            int l = left + 1;
            int r = right;
            while (true) {
                while (nums[l] < nums[left] && l < right) {
                    l += 1;
                }
                while (nums[r] > nums[left] && left < r) {
                    r -= 1;
                }
                if (l >= r) {
                    break;
                }
                swap(nums, l, r);
                l += 1;
                r -= 1;
            }
            swap(nums, left, r);
            if (r == target) {
                return nums[r];
            } else if (r > target) {
                right = r - 1;
            } else {
                left = r + 1;
            }
        }
        return nums[target];
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
//        int[] nums = {3, 5, 2, 4, 1, 6, 4, 3, 5};
        int[] nums = {3, 3, 3, 3, 3, 3};
        Solution s = new Solution();
        System.out.println(s.findKthLargest(nums, 4));
    }
}