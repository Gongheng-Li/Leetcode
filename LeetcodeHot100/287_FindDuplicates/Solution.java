class Solution {
    public int findDuplicate(int[] nums) {
        int bitNumber = 31;
        int n = nums.length - 1;
        int result = 0;
        while (n >> bitNumber == 0) {
            bitNumber -= 1;
        }
        for (int i = bitNumber; i >= 0; i--) {
            int countNumsBit = 0, countNaturalBit = 0;
            for (int j = 0; j <= n; j++) {
                if ((nums[j] & (1 << i)) != 0) {
                    countNumsBit += 1;
                }
                if (j != 0 && (j & (1 << i)) != 0) {
                    countNaturalBit += 1;
                }
            }
            if (countNumsBit > countNaturalBit) {
                result |= 1 << i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        Solution s = new Solution();
        System.out.println(s.findDuplicate(nums));
    }
}