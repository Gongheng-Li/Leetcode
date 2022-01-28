import java.util.Arrays;

class Solution {
    public int[] countBits(int n) {
        int highestBit = 0;
        int[] nums = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highestBit = i;
            }
            nums[i] = nums[i - highestBit] + 1;
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.countBits(5)));
    }
}