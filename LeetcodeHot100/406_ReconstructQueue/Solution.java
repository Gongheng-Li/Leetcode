import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, Comparator.comparingInt((int[] o) -> o[0]));
        int[][] result = new int[people.length][];
        for (int[] person : people) {
            int count = 0;
            for (int i = 0; i < people.length; i++) {
                if (result[i] == null) {
                    if (person[1] == count) {
                        result[i] = person;
                        break;
                    } else {
                        count += 1;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        Solution s = new Solution();
        System.out.println(Arrays.deepToString(s.reconstructQueue(people)));
    }
}