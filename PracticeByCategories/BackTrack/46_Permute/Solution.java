import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> combination = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        combine(nums, used, combination, result);
        return result;
    }

    private void combine(int[] nums, boolean[] used, List<Integer> combination, List<List<Integer>> result) {
        if (combination.size() == nums.length) {
            result.add(List.copyOf(combination));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                combination.add(nums[i]);
                combine(nums, used, combination, result);
                combination.remove(combination.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 3};
        System.out.println(s.permute(nums));
    }
}