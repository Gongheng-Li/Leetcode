class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int lowestPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price > lowestPrice) {
                maxProfit = Math.max(maxProfit, price - lowestPrice);
            } else {
                lowestPrice = price;
            }
        }
        return maxProfit;
    }
}