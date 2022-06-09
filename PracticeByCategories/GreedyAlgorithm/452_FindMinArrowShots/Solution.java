import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt((int[] o) -> o[1]));
        int arrowCount = 1;
        int arrowPos = points[0][1];
        for (int[] point : points) {
            if (point[0] > arrowPos) {
                arrowCount += 1;
                arrowPos = point[1];
            }
        }
        return arrowCount;
    }

    public static void main(String[] args) {
//        int[][] points = {{1, 2}, {3, 4}, {5, 6}, {7, 8}};
        int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        Solution solution = new Solution();
        System.out.println(solution.findMinArrowShots(points));
    }
}