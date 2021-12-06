class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length);
    }

    private int mergeSort(int[] nums, int start, int end) {
        if (end - start <= 1 || nums.length == 0) {
            return 0;
        }
        int middle = (start + end) / 2;
        int leftReversePairs = mergeSort(nums, start, middle);
        int rightReversePairs = mergeSort(nums, middle, end);
        int pairCount = 0;
        int[] sorted = new int[end - start];
        int i = start, j = middle, k = 0;
        while (i < middle && j < end) {
            if (nums[i] <= nums[j]) {
                sorted[k] = nums[i];
                i += 1;
            } else {
                sorted[k] = nums[j];
                j += 1;
                pairCount += middle - i;
            }
            k += 1;
        }
        System.arraycopy(nums, i, sorted, k, middle - i);
        System.arraycopy(nums, j, sorted, k, end - j);
        System.arraycopy(sorted, 0, nums, start, end - start);
        return pairCount + leftReversePairs + rightReversePairs;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {7, 5, 6, 4};
        int reversePairs = s.reversePairs(nums);
        System.out.println(reversePairs);
    }
}