import java.util.ArrayList;
import java.util.List;

class Solution {
    public int candy(int[] ratings) {
        List<Integer> bottoms = new ArrayList<>();
        for (int i = 0; i < ratings.length; i++) {
            if ((i == 0 || ratings[i] <= ratings[i - 1]) && (i == ratings.length - 1 || ratings[i] <= ratings[i + 1])) {
                bottoms.add(i);
            }
        }
        int[] candyNums = new int[ratings.length];
        for (int i = 0; i < bottoms.size(); i++) {
            int bottomIndex = bottoms.get(i);
            int lastBottomIndex = i == 0 ? -1 : bottoms.get(i - 1);
            int nextBottomIndex = i == bottoms.size() - 1 ? ratings.length : bottoms.get(i + 1);
            candyNums[bottomIndex] = 1;
            for (int j = bottomIndex - 1; j > lastBottomIndex && ratings[j] > ratings[j + 1]; j--) {
                candyNums[j] = Math.max(candyNums[j + 1] + 1, candyNums[j]);
            }
            for (int j = bottomIndex + 1; j < nextBottomIndex && ratings[j] > ratings[j - 1]; j++) {
                candyNums[j] = Math.max(candyNums[j - 1] + 1, candyNums[j]);
            }
        }
        int result = 0;
        for (int candyNum : candyNums) {
            result += candyNum;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 2, 87, 87, 87, 2, 1};
        Solution solution = new Solution();
        System.out.println(solution.candy(ratings));
    }
}