import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (int[] o1, int[] o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o2[1] - o1[1];
            }
        });
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