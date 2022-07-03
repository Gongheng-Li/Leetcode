class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] rememberCount = new long[forget];
        rememberCount[0] = 1;
        long sum = 1;
        long spreadCount = 0;
        for (int i = 1; i < n; i++) {
            int index = i % forget;
            sum -= rememberCount[index];
            spreadCount -= rememberCount[index];
            spreadCount += rememberCount[(i - delay + forget) % forget];
            sum += spreadCount;
            spreadCount = (spreadCount + (int) (1e9 + 7)) % (int) (1e9 + 7);
            sum = (sum + (int) (1e9 + 7)) % (int) (1e9 + 7);
            rememberCount[index] = spreadCount;
        }
        return (int) sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.peopleAwareOfSecret(684, 18, 496));
    }
}