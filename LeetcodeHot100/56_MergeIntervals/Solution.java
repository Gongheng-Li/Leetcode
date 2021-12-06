import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] currentRange = null;
        List<int[]> resultList = new ArrayList<>();
        for (int[] interval : intervals) {
            if (currentRange == null) {
                currentRange = new int[]{interval[0], interval[1]};
            } else {
                if (interval[0] > currentRange[1]) {
                    resultList.add(currentRange);
                    currentRange = new int[]{interval[0], interval[1]};
                } else {
                    currentRange[1] = Math.max(interval[1], currentRange[1]);
                }
            }
        }
        if (currentRange != null) {
            resultList.add(currentRange);
        }
        return resultList.toArray(new int[resultList.size()][2]);
//        int[][] result = new int[resultList.size()][2];
//        for (int i = 0; i < result.length; i++) {
//            result[i] = resultList.remove(0);
//        }
//        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {15, 18}, {8, 10}, {2, 6}};
        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.merge(intervals)));
    }
}