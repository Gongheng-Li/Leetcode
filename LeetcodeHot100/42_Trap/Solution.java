class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int volume = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    volume += leftMax - height[left];
                }
                left += 1;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    volume += rightMax - height[right];
                }
                right -= 1;
            }
        }
        return volume;
    }

    public static void main(String[] args) {
        int[] heights = {4, 2, 0, 3, 2, 5};
        Solution s = new Solution();
        System.out.println(s.trap(heights));
    }
}