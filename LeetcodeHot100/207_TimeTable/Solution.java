import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inCount = new int[numCourses];
        Queue<Integer> queue = new LinkedList<>();
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            inCount[edge[0]] += 1;
            adjacency.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (inCount[i] == 0) {
                queue.add(i);
            }
        }
        int count = numCourses;
        while (!queue.isEmpty()) {
            int thisElement = queue.poll();
            count -= 1;
            for (int adjacentElement : adjacency.get(thisElement)) {
                inCount[adjacentElement] -= 1;
                if (inCount[adjacentElement] == 0) {
                    queue.add(adjacentElement);
                }
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {{1, 0}, {0, 1}};
        Solution s = new Solution();
        System.out.println(s.canFinish(2, prerequisites));
    }
}