class Solution {
    public int[] exchange(int[] nums) {
        int odd = 0, even = nums.length - 1;
        while (odd < even) {
            while (nums[odd] % 2 == 1) {
                odd += 1;
                if (odd >= even) {
                    return nums;
                }
            }
            while (nums[even] % 2 == 0) {
                even -= 1;
                if (odd >= even) {
                    return nums;
                }
            }
            int temp = nums[odd];
            nums[odd] = nums[even];
            nums[even] = temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = {};
        int[] result = s.exchange(test);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}