import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == -1 || nums[nums[i] - 1] == -1) {
                i += 1;
            } else {
                boolean flag = nums[i] - 1 != i;
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = -1;
                if (flag) {
                    nums[i] = temp;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != -1) {
                result.add(j + 1);
                i += 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1};
        System.out.println(s.findDisappearedNumbers(nums));
    }
}