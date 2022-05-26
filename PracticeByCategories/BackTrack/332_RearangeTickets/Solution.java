import java.util.*;

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<Integer>> adjacentNodes = new HashMap<>();
        for (int i = 0; i < tickets.size(); i++) {
            List<String> ticket = tickets.get(i);
            List<Integer> adjacent = adjacentNodes.getOrDefault(ticket.get(0), new ArrayList<>());
            adjacent.add(i);
            adjacentNodes.put(ticket.get(0), adjacent);
        }
        for (String key : adjacentNodes.keySet()) {
            List<Integer> adjacent = adjacentNodes.get(key);
            adjacent.sort((Integer o1, Integer o2) -> {
                String s1 = tickets.get(o1).get(1), s2 = tickets.get(o2).get(1);
                for (int i = 0; i < 3; i++) {
                    if (s1.charAt(i) > s2.charAt(i)) {
                        return 1;
                    } else if (s1.charAt(i) < s2.charAt(i)) {
                        return -1;
                    }
                }
                return 0;
            });
        }
        boolean[] visited = new boolean[tickets.size()];
        List<String> combination = new ArrayList<>();
        combination.add("JFK");
        combine("JFK", adjacentNodes, combination, visited, tickets.size(), tickets);
        return combination;
    }

    private boolean combine(String startPos, Map<String, List<Integer>> adjacentNodes, List<String> combination,
                         boolean[] visited, int ticketsCount, List<List<String>> tickets) {
        if (ticketsCount == 0) {
            return true;
        }
        if (adjacentNodes.containsKey(startPos)) {
            List<Integer> adjacent = adjacentNodes.get(startPos);
            for (int index : adjacent) {
                if (!visited[index]) {
                    visited[index] = true;
                    List<String> ticket = tickets.get(index);
                    String destination = ticket.get(1);
                    combination.add(destination);
                    if (combine(destination, adjacentNodes, combination, visited, ticketsCount - 1, tickets)) {
                        return true;
                    }
                    visited[index] = false;
                    combination.remove(combination.size() - 1);
                }
            }
        }
        return false;
    }

    /*private static class CompareString implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            for (int i = 0; i < 3; i++) {
                if (o1.charAt(i) > o2.charAt(i)) {
                    return 1;
                } else if (o1.charAt(i) < o2.charAt(i)) {
                    return -1;
                }
            }
            return 0;
        }
    }*/
    /*private int compareString(String s1, String s2) {
        for (int i = 0; i < 3; i++) {
            if (s1.charAt(i) > s2.charAt(i)) {
                return 1;
            } else if (s1.charAt(i) < s2.charAt(i)) {
                return -1;
            }
        }
        return 0;
    }*/

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> tickets = new ArrayList<>();
//        tickets.add(List.of("MUC", "LHR"));
//        tickets.add(List.of("JFK", "MUC"));
//        tickets.add(List.of("SFO", "SJC"));
//        tickets.add(List.of("LHR", "SFO"));
        tickets.add(List.of("JFK", "SFO"));
        tickets.add(List.of("JFK", "ATL"));
        tickets.add(List.of("SFO", "ATL"));
        tickets.add(List.of("ATL", "JFK"));
        tickets.add(List.of("ATL", "SFO"));
        System.out.println(s.findItinerary(tickets));
    }
}