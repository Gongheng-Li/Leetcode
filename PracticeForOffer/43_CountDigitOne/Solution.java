class Solution {
    public int countDigitOne(int n) {
        int sum = 0;
        int pos = 1;
        while (pos <= 1e9 && n/pos > 0) {
            int leftPart = n / (pos * 10);
            if (pos >= 1e9) {
                leftPart = 0;
            }
            int rightPart = n % pos;
            int midDigit = (n / pos) % 10;
            sum += leftPart * pos;
            if (midDigit > 1) {
                sum += pos;
            } else if (midDigit > 0) {
                sum += 1 + rightPart;
            }
            pos *= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution testObj = new Solution();
        int testResult = testObj.countDigitOne(1410065408);
        System.out.println(testResult);
        int test = 1000000000;
        test *= 10;
        System.out.println(test);
        System.out.println(Integer.MAX_VALUE);
    }
}