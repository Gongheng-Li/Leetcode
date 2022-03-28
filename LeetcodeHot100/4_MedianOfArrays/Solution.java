class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if (totalLength % 2 == 0) {
            return (findKthMin(nums1, nums2, totalLength/2) + findKthMin(nums1, nums2, totalLength/2 + 1)) / 2.0;
        } else {
            return findKthMin(nums1, nums2, totalLength/2 + 1);
        }
    }

    private int findKthMin(int[] nums1, int[] nums2, int k) {
        int start1 = 0, start2 = 0;
        while (true) {
            if (start1 == nums1.length) {
                return nums2[start2 + k - 1];
            } else if (start2 == nums2.length) {
                return nums1[start1 + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[start1], nums2[start2]);
            }
//            int middle = k/2 - 1;
            int middle1 = start1 + k/2 - 1;
            int middle2 = start2 + k/2 - 1;
            if (middle1 >= nums1.length) {
                middle1 = nums1.length - 1;
            } else if (middle2 >= nums2.length) {
                middle2 = nums2.length - 1;
            }
            if (nums1[middle1] <= nums2[middle2]) {
                k -= middle1 - start1 + 1;
                start1 = middle1 + 1;
            } else {
                k -= middle2 - start2 + 1;
                start2 = middle2 + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2}, nums2 = {1, 3};
        Solution s = new Solution();
        System.out.println(s.findMedianSortedArrays(nums1, nums2));
    }
}