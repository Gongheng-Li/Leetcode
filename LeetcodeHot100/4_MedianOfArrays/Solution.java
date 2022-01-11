class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] longerArray, shorterArray;
        if (nums1.length < nums2.length) {
            longerArray = nums2;
            shorterArray = nums1;
        } else {
            longerArray = nums1;
            shorterArray = nums2;
        }
        int longerMiddle = longerArray.length / 2, shorterMiddle = shorterArray.length / 2;
        int leftBound = 0, rightBound = shorterArray.length - 1;
        while (leftBound <= rightBound) {
            if (shorterArray[shorterMiddle] > longerArray[longerMiddle + 1]) {
                rightBound = shorterMiddle - 1;
                longerMiddle += shorterMiddle - (leftBound + rightBound) / 2;
                shorterMiddle = (leftBound + rightBound) / 2;
            } else if (shorterArray[shorterMiddle] < longerArray[longerMiddle - 1]) {
                leftBound = shorterMiddle + 1;
                longerMiddle -= (leftBound + rightBound) / 2 - shorterMiddle;
                shorterMiddle = (leftBound + rightBound) / 2;
            } else {
                break;
            }
        }
        if (longerArray.length % 2 == 0 && shorterArray.length % 2 == 0) {
            return (Math.min(longerArray[longerMiddle], shorterArray[shorterMiddle]) +
                    Math.max(longerArray[longerMiddle - 1], shorterArray[shorterMiddle - 1])) / 2.0;
        } else if (longerArray.length % 2 == 1 && shorterArray.length % 2 == 1) {
            return (longerArray[longerMiddle] + shorterArray[shorterMiddle]) / 2.0;
        } else {
            return Math.min(longerArray[longerMiddle], shorterArray[shorterMiddle]);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3}, nums2 = {2};
        Solution s = new Solution();
        System.out.println(s.findMedianSortedArrays(nums1, nums2));
    }
}