class Solution {
    public int majorityElement(int[] nums) {
        int majorityNumber = 0;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                majorityNumber = num;
                count = 1;
            } else if (num == majorityNumber) {
                count += 1;
            } else {
                count -= 1;
            }
        }
        return majorityNumber;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        Solution s = new Solution();
        System.out.println(s.majorityElement(nums));
    }
}