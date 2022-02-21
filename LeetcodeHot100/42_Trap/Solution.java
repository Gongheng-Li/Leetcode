class Solution {
    public int trap(int[] height) {
        int volume = 0;
        int[] maxHeight = new int[height.length];
        maxHeight[maxHeight.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            maxHeight[i] = Math.max(maxHeight[i + 1], height[i]);
        }
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            int h = Math.min(max, maxHeight[i]);
            max = Math.max(max, height[i]);
            if (h > height[i]) {
                volume += h - height[i];
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