class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findLength(nums2, nums1);
        }
        int[] dp = new int[nums1.length];
        int maxLength = 0;
        for (int num : nums2) {
            for (int j = nums1.length - 1; j >= 0; j--) {
                if (nums1[j] == num) {
                    if (j > 0) {
                        dp[j] = dp[j - 1] + 1;
                    } else {
                        dp[j] = 1;
                    }
                    maxLength = Math.max(maxLength, dp[j]);
                } else {
                    dp[j] = 0;
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 2, 1};
        int[] nums2 = {3, 2, 1, 4, 7};
        Solution solution = new Solution();
        System.out.println(solution.findLength(nums1, nums2));
    }
}