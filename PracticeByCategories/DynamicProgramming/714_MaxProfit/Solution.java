class Solution {
    public int maxProfit(int[] prices, int fee) {
        int holdStock = Integer.MIN_VALUE, spare = 0;
        for (int price : prices) {
            int temp = Math.max(spare, holdStock + price);
            holdStock = Math.max(holdStock, spare - price - fee);
            spare = temp;
        }
        return spare;
    }

    public static void main(String[] args) {
//        int[] prices = {1, 3, 2, 8, 4, 9};
        int[] prices = {1, 3, 7, 5, 10, 3};
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(prices, 3));
    }
}