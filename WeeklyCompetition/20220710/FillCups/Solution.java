import javax.swing.*;
import java.util.Arrays;

class Solution {
    public int fillCups(int[] amount) {
        int count = 0;
        while (amount[0] != 0 || amount[1] != 0 || amount[2] != 0) {
//            int maxIndex = 0, minIndex = 0;
//            for (int i = 0; i < 3; i++) {
//                if (amount[i] > amount[maxIndex]) {
//                    maxIndex = i;
//                }
//                if (amount[i] < amount[minIndex]) {
//                    minIndex = i;
//                }
//            }
//            amount[maxIndex] -= 1;
//            if (amount[3 - maxIndex - minIndex] != 0) {
//                amount[3 - maxIndex - minIndex] -= 1;
//            }
            Arrays.sort(amount);
            amount[2] -= 1;
            if (amount[1] > 0) {
                amount[1] -= 1;
            }
            count += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] amount = {5, 4, 4};
        Solution solution = new Solution();
        System.out.println(solution.fillCups(amount));
    }
}