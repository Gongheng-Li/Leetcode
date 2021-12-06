import java.util.Set;
import java.util.HashSet;

public class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> intSet = new HashSet<>();
        for (int num : nums) {
            if (intSet.contains(num)) {
                return num;
            }
            intSet.add(num);
        }
        return -1;
    }
}