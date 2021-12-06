class Solution {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        long result = 1;
        while (n > 4) {
            result = result * 3 % (int) (1e9 + 7);
            n -= 3;
        }
        result = result * n % (int) (1e9 + 7);
        return (int) result;
    }
}