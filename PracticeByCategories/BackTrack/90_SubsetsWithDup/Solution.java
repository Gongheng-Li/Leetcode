import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> combination = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        combine(nums, 0, combination, result);
        return result;
    }

    private void combine(int[] nums, int start, List<Integer> combination, List<List<Integer>> result) {
        if (start == nums.length) {
            result.add(List.copyOf(combination));
            return;
        }
        int end = start + 1;
        while (end < nums.length && nums[end] == nums[start]) {
            end += 1;
        }
        combine(nums, end, combination, result);
        for (int i = start; i < end; i++) {
            combination.add(nums[start]);
            combine(nums, end, combination, result);
        }
        for (int i = 0; i < end - start; i++) {
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0};
        System.out.println(s.subsetsWithDup(nums));
    }
}