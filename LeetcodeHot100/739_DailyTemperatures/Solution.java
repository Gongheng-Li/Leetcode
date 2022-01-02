import java.util.Arrays;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] daysToBeHotter = new int[temperatures.length];
        daysToBeHotter[temperatures.length - 1] = 0;
        for (int i = temperatures.length - 2; i >= 0; i--) {
            int target = i + 1;
            while (target < temperatures.length) {
                if (temperatures[i] < temperatures[target]) {
                    daysToBeHotter[i] = target - i;
                    break;
                } else {
                    if (daysToBeHotter[target] == 0) {
                        daysToBeHotter[i] = 0;
                        break;
                    } else {
                        target += daysToBeHotter[target];
                    }
                }
            }
        }
        return daysToBeHotter;
    }

    public static void main(String[] args) {
        int[] temperatures = {30, 60, 90};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.dailyTemperatures(temperatures)));
    }
}