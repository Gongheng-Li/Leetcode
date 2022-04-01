class Solution {
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int hammingDistance = 0;
        while (n != 0) {
            n &= n - 1;
            hammingDistance += 1;
        }
        return hammingDistance;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.hammingDistance(1, 4));
    }
}