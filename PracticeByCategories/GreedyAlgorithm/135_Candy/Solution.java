class Solution {
    public int candy(int[] ratings) {
        int pre = 1;
        int result = 1;
        int descCount = 0, incCount = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                if (pre == 1) {
                    incCount = 1;
                }
                descCount = 0;
                pre += 1;
                incCount += 1;
                result += pre;
            } else if (ratings[i] < ratings[i - 1]) {
                pre = 1;
                descCount += 1;
                if (descCount == incCount) {
                    descCount += 1;
                }
                result += descCount;
            } else {
                pre = 1;
                descCount = 0;
                incCount = 1;
                result += 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 2, 87, 87, 87, 2, 1};
        Solution solution = new Solution();
        System.out.println(solution.candy(ratings));
    }
}