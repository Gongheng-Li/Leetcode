class Solution {
    public int candy(int[] ratings) {
        int[] candyNums = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                candyNums[i] = candyNums[i - 1] + 1;
            } else {
                candyNums[i] = 1;
            }
        }
        int result = 0;
        int rightCount = 1;
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i < ratings.length - 1 && ratings[i] > ratings[i + 1]) {
                rightCount += 1;
            } else {
                rightCount = 1;
            }
            result += Math.max(candyNums[i], rightCount);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 2, 2};
        Solution solution = new Solution();
        System.out.println(solution.candy(ratings));
    }
}