import java.util.Arrays;

class Solution {
    public int[] countBits(int n) {
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            nums[i] = nums[i & (i - 1)] + 1;
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.countBits(5)));
    }
}