import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<Integer> combination = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        combine(nums, 0, combination, result);
        return result;
    }

    private void combine(int[] nums, int start, List<Integer> combination, List<List<Integer>> result) {
        if (combination.size() >= 2) {
            result.add(List.copyOf(combination));
        }
        if (start >= nums.length) {
            return;
        }
        Set<Integer> duplicates = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (!duplicates.contains(nums[i]) && (combination.isEmpty() || combination.get(combination.size() - 1) <= nums[i])) {
                combination.add(nums[i]);
                combine(nums, i + 1, combination, result);
                combination.remove(combination.size() - 1);
                duplicates.add(nums[i]);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        int[] nums = {4, 4, 3, 2, 1};
        int[] nums = {1, 3, 1, 1};
        System.out.println(s.findSubsequences(nums));
    }
}