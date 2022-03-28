class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int left = 0, right = nums1.length;
        int leftMax = 0, rightMin = 0;
        int totalLength = nums1.length + nums2.length;
        int sum = (totalLength + 1) / 2;
        while (left <= right) {
            int m = (left + right) / 2;
            int n = sum - m;
            int num1left = Integer.MIN_VALUE, num1right = Integer.MAX_VALUE;
            int num2left = Integer.MIN_VALUE, num2right = Integer.MAX_VALUE;
            if (m > 0) {
                num1left = nums1[m - 1];
            }
            if (m < nums1.length) {
                num1right = nums1[m];
            }
            if (n > 0) {
                num2left = nums2[n - 1];
            }
            if (n < nums2.length) {
                num2right = nums2[n];
            }
            if (num1left <= num2right) {
                leftMax = Math.max(num1left, num2left);
                rightMin = Math.min(num1right, num2right);
                left = m + 1;
            } else {
                right = m - 1;
            }
        }
        if (totalLength % 2 == 0) {
            return (leftMax + rightMin) / 2.0;
        } else {
            return leftMax;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2}, nums2 = {1, 3};
        Solution s = new Solution();
        System.out.println(s.findMedianSortedArrays(nums1, nums2));
    }
}