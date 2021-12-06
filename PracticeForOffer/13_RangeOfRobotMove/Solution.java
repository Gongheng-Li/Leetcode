import java.util.HashSet;
import java.util.Set;

class Solution {
    public int movingCount(int m, int n, int k) {
        Set<Integer> visited = new HashSet<>();
        visit(0, 0, m, n, k, visited);
        return visited.size();
    }

    private void visit(int x, int y, int m, int n, int k, Set<Integer> visited) {
        if (x >= m || y >= n || visited.contains(x * n + y) || outOfRange(x, y, k)) {
            return;
        }
        visited.add(x * n + y);
        visit(x + 1, y, m, n, k, visited);
        visit(x, y + 1, m, n, k, visited);
    }

    private boolean outOfRange(int x, int y, int k) {
        return digitSum(x) + digitSum(y) > k;
    }

    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.movingCount(4, 6, 15));
    }
}