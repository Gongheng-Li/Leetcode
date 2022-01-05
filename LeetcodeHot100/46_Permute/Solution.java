import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> onePermutation = new ArrayList<>();
        permute(nums, 0, onePermutation, result);
        return result;
    }

    private void permute(int[] nums, int index, List<Integer> onePermutation, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(List.copyOf(onePermutation));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            onePermutation.add(nums[i]);
            swap(nums, index, i);
            permute(nums, index + 1, onePermutation, result);
            swap(nums, index, i);
            onePermutation.remove(onePermutation.size() - 1);
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution s = new Solution();
        System.out.println(s.permute(nums));
    }
}