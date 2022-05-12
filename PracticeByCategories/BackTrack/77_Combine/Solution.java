import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> combination = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        combine(1, n, k, k, result, combination);
        return result;
    }

    private void combine(int start, int end, int totalCount, int k, List<List<Integer>> result, List<Integer> combination) {
        if (end - start + 1 < k) {
            return;
        }
        for (int i = start; i <= end; i++) {
            combination.add(i);
            if (combination.size() == totalCount) {
                result.add(List.copyOf(combination));
            } else {
                combine(i + 1, end, totalCount, k - 1, result, combination);
            }
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.combine(4, 2));
    }
}