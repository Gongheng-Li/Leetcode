import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> combination = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        permute(nums, used, combination, result);
        return result;
    }

    private void permute(int[] nums, boolean[] used, List<Integer> combination, List<List<Integer>> result) {
        if (combination.size() == nums.length) {
            result.add(List.copyOf(combination));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                used[i] = true;
                combination.add(nums[i]);
                permute(nums, used, combination, result);
                combination.remove(combination.size() - 1);
                used[i] = false;
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    i += 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 1, 3};
        System.out.println(s.permuteUnique(nums));
    }
}