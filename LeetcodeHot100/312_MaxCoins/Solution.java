import java.util.Arrays;

public class Solution {
    public int maxCoins(int[] nums) {
        int[] extendedNums = new int[nums.length + 2];
        extendedNums[0] = 1;
        extendedNums[nums.length + 1] = 1;
        System.arraycopy(nums, 0, extendedNums, 1, nums.length);
        int[][] rememberedSet = new int[nums.length + 2][nums.length + 2];
        for (int[] ints : rememberedSet) {
            Arrays.fill(ints, -1);
        }
        return helper(extendedNums, 0, nums.length + 1, rememberedSet);
    }

    private int helper(int[] nums, int start, int end, int[][] rememberedSet) {
        if (start >= end - 1) {
            return 0;
        }
        if (rememberedSet[start][end] != -1) {
            return rememberedSet[start][end];
        }
        int sum = 0;
        for (int i = start + 1; i < end; i++) {
            int iSum = nums[i] * nums[start] * nums[end] +
                    helper(nums, start, i, rememberedSet) + helper(nums, i, end, rememberedSet);
            sum = Math.max(sum, iSum);
        }
        rememberedSet[start][end] = sum;
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3, 1, 5, 8};
        System.out.println(s.maxCoins(nums));
    }
}
