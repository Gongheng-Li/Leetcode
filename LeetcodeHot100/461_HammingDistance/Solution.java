class Solution {
    public int hammingDistance(int x, int y) {
        int hammingDistance = 0;
        while (x != 0 || y != 0) {
            if ((x & 1) != (y & 1)) {
                hammingDistance += 1;
            }
            x >>= 1;
            y >>= 1;
        }
        return hammingDistance;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.hammingDistance(1, 3));
    }
}