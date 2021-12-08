import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numSquares(int n) {
        return numSquares(n, new HashMap<>());
    }

    private int numSquares(int n, Map<Integer, Integer> divideMap) {
        if (n == 0) {
            return 0;
        }
        if (divideMap.containsKey(n)) {
            return divideMap.get(n);
        }
        int maxRoot = (int) Math.sqrt(n);
        int minNumber = Integer.MAX_VALUE;
        for (int i = maxRoot; i >= 1; i--) {
            minNumber = Math.min(minNumber, numSquares(n - i * i, divideMap) + 1);
        }
        divideMap.put(n, minNumber);
        return minNumber;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numSquares(11));
    }
}