import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longestLength = 0;
        for (int num : nums) {
            if (!numSet.contains(num - 1)) {
                int length = 0;
                int sweepNum = num;
                while (numSet.contains(sweepNum)) {
                    length += 1;
                    sweepNum += 1;
                }
                longestLength = Math.max(longestLength, length);
            }
        }
        return longestLength;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2, 4};
        Solution s = new Solution();
        System.out.println(s.longestConsecutive(nums));
    }
}