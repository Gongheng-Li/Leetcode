import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> combination = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        combine(nums, 0, combination, result);
        return result;
    }

    private void combine(int[] nums, int start, List<Integer> combination, List<List<Integer>> result) {
        if (start == nums.length) {
            result.add(List.copyOf(combination));
            return;
        }
        combine(nums, start + 1, combination, result);
        combination.add(nums[start]);
        combine(nums, start + 1, combination, result);
        combination.remove(combination.size() - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 3};
        System.out.println(s.subsets(nums));
    }
}