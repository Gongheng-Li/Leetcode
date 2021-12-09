class Solution {
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);
        int ptr = 0;
        while (ptr != slow) {
            ptr = nums[ptr];
            slow = nums[slow];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        Solution s = new Solution();
        System.out.println(s.findDuplicate(nums));
    }
}