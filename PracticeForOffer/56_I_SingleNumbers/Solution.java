class Solution {
    public int[] singleNumbers(int[] nums) {
        int aXorB = 0;
        for (int num : nums) {
            aXorB ^= num;
        }
        int m = 1;
        while ((aXorB & m) == 0) {
            m <<= 1;
        }
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & m) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 10, 4, 1, 4, 3, 3};
        Solution s = new Solution();
        int[] result = s.singleNumbers(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}