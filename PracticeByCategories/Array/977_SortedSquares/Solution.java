import java.util.Arrays;

class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] square = new int[nums.length];
        int left = 0, right = nums.length - 1;
        int zero = 0;
        while (left <= right) {
            zero = (left + right) / 2;
            if (nums[zero] < 0) {
                left = zero + 1;
            } else {
                right = zero - 1;
            }
        }
        int ptr1 = 0, ptr2 = 0;
        if (nums[zero] >= 0) {
            ptr1 = zero;
            ptr2 = zero - 1;
        } else {
            ptr1 = zero + 1;
            ptr2 = zero;
        }
        int i = 0;
        while (ptr1 < nums.length && ptr2 >= 0) {
            if (Math.abs(nums[ptr1]) < Math.abs(nums[ptr2])) {
                square[i] = nums[ptr1] * nums[ptr1];
                ptr1 += 1;
            } else {
                square[i] = nums[ptr2] * nums[ptr2];
                ptr2 -= 1;
            }
            i += 1;
        }
        for (int j = ptr2; j >= 0; j--) {
            square[i] = nums[j] * nums[j];
            i += 1;
        }
        for (int j = ptr1; j < nums.length; j++) {
            square[i] = nums[j] * nums[j];
            i += 1;
        }
        return square;
    }

    public static void main(String[] args) {
        int[] nums = {-1};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.sortedSquares(nums)));
    }
}