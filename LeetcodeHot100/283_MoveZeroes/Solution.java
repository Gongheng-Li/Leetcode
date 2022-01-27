import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public void moveZeroes(int[] nums) {
        List<Integer> zeroPositions = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroPositions.add(i);
            }
        }
        int zeroCount = 0;
        for (int i = 0; i < nums.length - zeroPositions.size(); i++) {
            while (zeroCount < zeroPositions.size() && i + zeroCount >= zeroPositions.get(zeroCount)) {
                zeroCount += 1;
            }
            nums[i] = nums[i + zeroCount];
        }
        for (int i = nums.length - zeroPositions.size(); i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 0, 3, 12, 0, 0};
        Solution s = new Solution();
        s.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}