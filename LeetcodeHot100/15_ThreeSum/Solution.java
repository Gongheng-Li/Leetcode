import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        while (i < nums.length - 2) {
            int setValue = nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int leftValue = nums[left], rightValue = nums[right];
                int sum = setValue + leftValue + rightValue;
                if (sum == 0) {
                    List<Integer> combination = new ArrayList<>();
                    combination.add(setValue);
                    combination.add(leftValue);
                    combination.add(rightValue);
                    result.add(combination);
                    while (left < right && nums[left] == leftValue) {
                        left += 1;
                    }
                    while (left < right && nums[right] == rightValue) {
                        right -= 1;
                    }
                } else if (sum < 0) {
                    while (left < right && nums[left] == leftValue) {
                        left += 1;
                    }
                } else {
                    while (left < right && nums[right] == rightValue) {
                        right -= 1;
                    }
                }
                while (i < nums.length - 2 && nums[i] == setValue) {
                    i += 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Solution s = new Solution();
        List<List<Integer>> result = s.threeSum(nums);
        for (List<Integer> combination : result) {
            System.out.println(combination.toString());
        }
    }
}