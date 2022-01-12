class Solution {
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int formerOfFormer = 1, former = 2;
        for (int i = 2; i < n; i++) {
            int temp = former;
            former = formerOfFormer + former;
            formerOfFormer = temp;
        }
        return former;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.climbStairs(4));
    }
}