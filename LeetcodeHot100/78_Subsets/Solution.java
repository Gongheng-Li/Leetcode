import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        dfs(nums, 0, result, combination);
        return result;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> result, List<Integer> combination) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(combination));
            return;
        }
        dfs(nums, index + 1, result, combination);
        combination.add(nums[index]);
        dfs(nums, index + 1, result, combination);
        combination.remove(combination.size() - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution s = new Solution();
        System.out.println(s.subsets(nums));
    }
}