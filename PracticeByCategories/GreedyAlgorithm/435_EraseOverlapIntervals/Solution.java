import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] o) -> o[0]));
        int rightMost = Integer.MAX_VALUE;
        int removeCount = -1;
        for (int[] interval : intervals) {
            if (interval[0] < rightMost) {
                removeCount += 1;
                rightMost = Math.min(interval[1], rightMost);
            } else {
                rightMost = interval[1];
            }
        }
        return removeCount;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {1, 2}};
        Solution solution = new Solution();
        System.out.println(solution.eraseOverlapIntervals(intervals));
    }
}