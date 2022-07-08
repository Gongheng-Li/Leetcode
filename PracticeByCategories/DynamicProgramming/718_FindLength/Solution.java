class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            return findLength(nums2, nums1);
        }
        int m = nums1.length, n = nums2.length;
        int maxLength = 0;
        for (int i = 1; i <= n; i++) {
            maxLength = Math.max(maxLength, maxInOverlap(nums1, 0, i, nums2, n - i, n));
        }
        for (int i = 1; i < m; i++) {
            int end1 = Math.min(i + n, m);
            int end2 = Math.min(n, m - i);
            maxLength = Math.max(maxLength, maxInOverlap(nums1, i, end1, nums2, 0, end2));
        }
        return maxLength;
    }

    private int maxInOverlap(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2) {
        int count = 0, maxLength = 0;
        for (int i = start1, j = start2; i < end1; i++, j++) {
            if (nums1[i] == nums2[j]) {
                count += 1;
                maxLength = Math.max(maxLength, count);
            } else {
                count = 0;
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