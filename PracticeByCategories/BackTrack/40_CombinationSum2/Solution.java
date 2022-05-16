import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> combination = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        combine(candidates, target, 0, combination, result);
        return result;
    }

    private void combine(int[] candidates, int target, int start, List<Integer> combination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(List.copyOf(combination));
            return;
        }
        if (start >= candidates.length || target < candidates[start]) {
            return;
        }
        int i = start;
        while (i < candidates.length) {
            int repeatStart = i, repeatEnd = i;
            while (repeatEnd + 1 < candidates.length && candidates[repeatEnd + 1] == candidates[repeatEnd]) {
                repeatEnd += 1;
            }
            int repeatTarget = target;
            while (i <= repeatEnd) {
                combination.add(candidates[i]);
                repeatTarget -= candidates[i];
                if (repeatTarget < 0) {
                    i += 1;
                    break;
                }
                combine(candidates, repeatTarget, repeatEnd + 1, combination, result);
                i += 1;
            }
            for (int j = repeatStart; j < i; j++) {
                combination.remove(combination.size() - 1);
            }
            i = repeatEnd + 1;
        }
    }

    public static void main(String[] args) {
        int[] candidates = {4, 1, 1, 4, 4, 4, 4, 2, 3, 5};
        Solution s = new Solution();
        System.out.println(s.combinationSum2(candidates, 10));
    }
}