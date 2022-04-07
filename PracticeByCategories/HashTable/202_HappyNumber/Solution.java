class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = makeHappy(n);
        while (fast != 1) {
            if (fast == slow) {
                return false;
            }
            fast = makeHappy(makeHappy(fast));
            slow = makeHappy(slow);
        }
        return true;
    }

    private int makeHappy(int n) {
        int temp = 0;
        while (n > 0) {
            temp += (n % 10) * (n % 10);
            n /= 10;
        }
        return temp;
    }
}