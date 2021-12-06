class Solution {
    public int maxProduct(int[] nums) {
        int maxEndWithThis = 1;
        int minEndWithThis = 1;
        int maxValue = Integer.MIN_VALUE;
        for (int num : nums) {
            int tempMax = maxEndWithThis;
            maxEndWithThis = Math.max(maxEndWithThis * num, minEndWithThis * num);
            maxEndWithThis = Math.max(maxEndWithThis, num);
            maxValue = Math.max(maxValue, maxEndWithThis);
            minEndWithThis = Math.min(tempMax * num, minEndWithThis * num);
            minEndWithThis = Math.min(minEndWithThis, num);
        }
        return maxValue;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4, -1};
        Solution s = new Solution();
        System.out.println(s.maxProduct(nums));
    }
}