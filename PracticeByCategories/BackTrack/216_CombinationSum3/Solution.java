import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] maxSinceHere = new int[10];
        maxSinceHere[9] = 9;
        for (int i = 8; i > 0; i--) {
            maxSinceHere[i] = maxSinceHere[i + 1] + i;
        }
        List<Integer> combination = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        combine(1, n, k, combination, result, maxSinceHere);
        return result;
    }

    private void combine(int start, int target, int count, List<Integer> combination, List<List<Integer>> result, int[] maxSinceHere) {
        if (start >= 10 || target < start || target > maxSinceHere[start]) {
            return;
        }
        for (int i = start; i < 10; i++) {
            combination.add(i);
            if (target - i == 0 && combination.size() == count) {
                result.add(List.copyOf(combination));
            } else if (combination.size() < count) {
                combine(i + 1, target - i, count, combination, result, maxSinceHere);
            }
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.combinationSum3(3, 7));
    }
}