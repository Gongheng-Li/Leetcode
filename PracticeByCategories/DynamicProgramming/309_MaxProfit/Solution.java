class Solution {
    public int maxProfit(int[] prices) {
        int spare = 0, holdStock = Integer.MIN_VALUE, frozen = 0;
        for (int price : prices) {
            int newSpare, newHoldStock, newFrozen;
            newSpare = Math.max(spare, frozen);
            newHoldStock = Math.max(holdStock, spare - price);
            newFrozen = holdStock + price;
            spare = newSpare;
            holdStock = newHoldStock;
            frozen = newFrozen;
        }
        return Math.max(spare, frozen);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] prices = {1, 2, 3, 0, 2};
        int[] prices = {1};
        System.out.println(solution.maxProfit(prices));
    }
}