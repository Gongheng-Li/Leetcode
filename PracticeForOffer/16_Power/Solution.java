class Solution {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1) {
            return 1;
        } else if (n == 1) {
            return x;
        } else if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1 / (x * myPow(x, -1 * (n + 1)));
            }
            return 1 / myPow(x, -1 * n);
        } else if (n % 2 == 0) {
            double halfPow = myPow(x, n / 2);
            return halfPow * halfPow;
        } else {
            double halfPow = myPow(x, n / 2);
            return x * halfPow * halfPow;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.myPow(2.0, Integer.MIN_VALUE));
    }
}