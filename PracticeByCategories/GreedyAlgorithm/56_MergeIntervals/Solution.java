import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] o) -> o[0]));
        List<int[]> result = new ArrayList<>();
        int start = -1, end = -1;
        for (int[] interval : intervals) {
            if (interval[0] > end) {
                if (start != -1) {
                    result.add(new int[]{start, end});
                }
                start = interval[0];
                end = interval[1];
            } else {
                end = Math.max(end, interval[1]);
            }
        }
        result.add(new int[]{start, end});
        int[][] resultArray = new int[result.size()][2];
        return result.toArray(resultArray);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.merge(intervals)));
    }
}