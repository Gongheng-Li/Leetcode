class Solution {
    public int search(int[] nums, int target) {
        int begin = 0, end = nums.length - 1;
        while (begin <= end) {
            int middle = (begin + end) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] >= nums[0]) {
                if (target >= nums[0] && target < nums[middle]) {
                    end = middle - 1;
                } else {
                    begin = middle + 1;
                }
            } else {
                if (target >= nums[middle] && target < nums[0]) {
                    begin = middle + 1;
                } else {
                    end = middle - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6};
        Solution s = new Solution();
        System.out.println(s.search(nums, 6));
    }
}