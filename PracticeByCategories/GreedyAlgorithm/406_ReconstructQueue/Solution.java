import java.util.Arrays;

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
            int targetPos = person[1];
            int j = 0, emptyCount = 0;
            while (emptyCount < targetPos || result[j] != null) {
                if (result[j] == null) {
                    emptyCount += 1;
                }
                j += 1;
            }
            result[j] = person;
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] testArray = new int[2][2];
        System.out.println(Arrays.toString(testArray[0]));
    }
}