import java.util.Arrays;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        output[0] = 1;
        int forwardProduct = 1;
        for (int i = 1; i < nums.length; i++) {
            forwardProduct *= nums[i - 1];
            output[i] = forwardProduct;
        }
        int backwardProduct = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            backwardProduct *= nums[i + 1];
            output[i] *= backwardProduct;
        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.productExceptSelf(nums)));
    }
}