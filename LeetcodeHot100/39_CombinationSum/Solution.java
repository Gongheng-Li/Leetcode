import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        helper(candidates, target, result, combination, 0);
        return result;
    }

    private void helper(int[] candidates, int target, List<List<Integer>> result, List<Integer> combination,
                        int index) {
        if (index >= candidates.length || target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        helper(candidates, target, result, combination, index + 1);
        if (target >= candidates[index]) {
            combination.add(candidates[index]);
            helper(candidates, target - candidates[index], result, combination, index);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        Solution s = new Solution();
        List<List<Integer>> result = s.combinationSum(candidates, 8);
        for (List<Integer> combination : result) {
            System.out.println(combination.toString());
//            for (int element : combination) {
//                System.out.print(element + " ");
//            }
//            System.out.println();
        }
    }
}