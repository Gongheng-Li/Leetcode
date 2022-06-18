class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev = 0, curr = 0;
        for (int i = 2; i <= cost.length; i++) {
            int temp = Math.min(prev + cost[i - 2], curr + cost[i - 1]);
            prev = curr;
            curr = temp;
        }
        return curr;
    }
}