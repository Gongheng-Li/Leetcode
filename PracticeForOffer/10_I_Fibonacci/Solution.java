import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Integer> cache = new HashMap<>();

    public int fib(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        if (n == 0 || n == 1) {
            cache.put(n, n);
            return n;
        } else {
            int result = fib(n - 2) + fib(n - 1);
            result %= 1e9 + 7;
            cache.put(n, result);
            return result;
        }
    }
}