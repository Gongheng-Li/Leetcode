class Solution {
    private int[] cache = new int[101];

    public int numWays(int n) {
        if (cache[n] != 0) {
            return cache[n];
        }
        if (n == 0) {
            cache[n] = 1;
            return 1;
        } else if (n == 1 || n == 2) {
            cache[n] = n;
            return n;
        } else {
            int result = numWays(n - 2) + numWays(n - 1);
            result %= 1e9 + 7;
            cache[n] = result;
            return  result;
        }
    }
}