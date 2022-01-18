class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 2, 1};
        Solution s = new Solution();
        System.out.println(s.singleNumber(nums));
    }
}