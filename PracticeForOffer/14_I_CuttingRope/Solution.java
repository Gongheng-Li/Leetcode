import java.util.HashMap;
import java.util.Map;

class Solution {
    private static Map<Integer, Integer> cache = new HashMap<>();

    public static int cuttingRope(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        if (n == 1) {
            cache.put(1, 1);
            return 1;
        }
        int largest = 0;
        for (int i = 1; i < n; i++) {
            int potentialLarger = Math.max(i * cuttingRope(n - i), i * (n - i));
            if (largest < potentialLarger) {
                largest = potentialLarger;
            }
        }
        cache.put(n, largest);
        return largest;
    }

    public static void main(String[] args) {
        System.out.println(cuttingRope(10));
    }
}