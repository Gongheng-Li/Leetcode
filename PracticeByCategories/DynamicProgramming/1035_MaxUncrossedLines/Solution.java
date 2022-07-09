class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return maxUncrossedLines(nums2, nums1);
        }
        int m = nums1.length, n = nums2.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            int prev = 0;
            for (int j = 1; j <= n; j++) {
                int temp = dp[j];
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = prev + 1;
                } else {
                    dp[j] = Math.max(dp[j - 1], dp[j]);
                }
                prev = temp;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
//        int[] nums1 = {1, 4, 2};
//        int[] nums2 = {1, 2, 4};
        int[] nums1 = {2, 5, 1, 2, 5};
        int[] nums2 = {10, 5, 2, 1, 5, 2};
        Solution solution = new Solution();
        System.out.println(solution.maxUncrossedLines(nums1, nums2));
    }
}