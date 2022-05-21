import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int subsetCount = 1 << nums.length;
        for (int i = 0; i < subsetCount; i++) {
            int indexes = i;
            List<Integer> combination = new ArrayList<>();
            for (int num : nums) {
                if (indexes == 0) {
                    break;
                }
                if ((indexes & 1) == 1) {
                    combination.add(num);
                }
                indexes >>= 1;
            }
            result.add(combination);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 3};
        System.out.println(s.subsets(nums));
    }
}