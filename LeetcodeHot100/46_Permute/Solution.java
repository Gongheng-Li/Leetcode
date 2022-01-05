import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> numList = new LinkedList<>();
        for (int num : nums) {
            numList.addLast(num);
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> onePermutation = new ArrayList<>();
        permute(numList, onePermutation, result);
        return result;
    }

    private void permute(LinkedList<Integer> numList, List<Integer> onePermutation, List<List<Integer>> result) {
        if (numList.isEmpty()) {
            result.add(List.copyOf(onePermutation));
            return;
        }
        int length = numList.size();
        for (int i = 0; i < length; i++) {
            int num = numList.removeFirst();
            onePermutation.add(num);
            permute(numList, onePermutation, result);
            onePermutation.remove(onePermutation.size() - 1);
            numList.addLast(num);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        Solution s = new Solution();
        System.out.println(s.permute(nums));
    }
}