class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int withStock = -1 * prices[0], withoutStock = 0;
        for (int price : prices) {
            int temp = withStock;
            withStock = Math.max(withoutStock - price, withStock);
            withoutStock = Math.max(temp + price, withoutStock);
        }
        return withoutStock;
    }
}