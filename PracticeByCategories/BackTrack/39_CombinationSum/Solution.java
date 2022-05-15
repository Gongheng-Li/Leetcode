import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        combine(candidates, target, 0, combination, result);
        return result;
    }

    private void combine(int[] candidates, int target, int start, List<Integer> combination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(List.copyOf(combination));
            return;
        }
        if (target < 0 || start >= candidates.length) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]);
            combine(candidates, target - candidates[i], i, combination, result);
            combination.remove(combination.size() - 1);
        }
    }
}