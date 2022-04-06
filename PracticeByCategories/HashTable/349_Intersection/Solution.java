import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersection(nums2, nums1);
        }
        Set<Integer> numSet = new HashSet<>();
        for (int j : nums1) {
            numSet.add(j);
        }
        Set<Integer> resultSet = new HashSet<>();
        for (int j : nums2) {
            if (numSet.contains(j)) {
                resultSet.add(j);
            }
        }
        int[] result = new int[resultSet.size()];
        int i = 0;
        for (int num : resultSet) {
            result[i] = num;
            i += 1;
        }
        return result;
    }
}