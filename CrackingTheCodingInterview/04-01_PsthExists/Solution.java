import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        Map<Integer, Set<Integer>> adjacentNodes = new HashMap<>();
        for (int[] edge : graph) {
            if (adjacentNodes.containsKey(edge[0])) {
                adjacentNodes.get(edge[0]).add(edge[1]);
            } else {
                Set<Integer> nodes = new HashSet<>();
                nodes.add(edge[1]);
                adjacentNodes.put(edge[0], nodes);
            }
        }
        boolean[] flags = new boolean[n];
        return existsPathsHelper(adjacentNodes, start, target, flags);
    }

    private boolean existsPathsHelper(Map<Integer, Set<Integer>> adjacentNodes, int start, int target, boolean[] flags) {
        if (start == target) {
            return true;
        }
        if (!adjacentNodes.containsKey(start) || flags[start]) {
            return false;
        }
        flags[start] = true;
        Set<Integer> nodes = adjacentNodes.get(start);
        for (int node : nodes) {
            if (existsPathsHelper(adjacentNodes, node, target, flags)) {
                return true;
            }
        }
        flags[start] = false;
        return false;
    }
}