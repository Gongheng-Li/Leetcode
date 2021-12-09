class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int left = 1, right = n;
        int result = 0;
        while (left <= right) {
            int middle = (left + right) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= middle) {
                    count += 1;
                }
            }
            if (count <= middle) {
                left = middle + 1;
            } else {
                right = middle - 1;
                result = middle;
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