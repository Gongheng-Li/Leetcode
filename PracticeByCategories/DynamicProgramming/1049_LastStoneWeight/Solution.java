class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int bonus = sum % 2;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        if (stones[0] <= target) {
            dp[stones[0]] = true;
        }
        for (int i = 1; i < stones.length; i++) {
            int stone = stones[i];
            for (int j = target; j >= stone; j--) {
                dp[j] |= dp[j - stone];
            }
        }
        for (int i = target; i >= 0; i--) {
            if (dp[i]) {
                return (target - i) * 2 + bonus;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        Solution solution = new Solution();
        System.out.println(solution.lastStoneWeightII(stones));
    }
}