class Solution {
    public int wiggleMaxLength(int[] nums) {
        int direction = 0;
        int result = 0;
        int last = -1;
        for (int num : nums) {
            if (direction > 0) {
                if (num > last) {
                    result += 1;
                    direction = -1;
                }
            } else if (direction < 0) {
                if (num < last) {
                    result += 1;
                    direction = 1;
                }
            } else {
                if (last == -1) {
                    result += 1;
                } else if (num > last) {
                    direction = -1;
                    result += 1;
                } else if (num < last) {
                    direction = 1;
                    result += 1;
                }
            }
            last = num;
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 7, 4, 9, 2, 5};
//        int[] nums = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
//        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] nums = {1, 1, 1, 1, 1};
        Solution solution = new Solution();
        System.out.println(solution.wiggleMaxLength(nums));
    }
}