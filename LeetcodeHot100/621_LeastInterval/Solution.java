import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> charCount = new HashMap<>();
        int maxExecuteTimes = 0;
        int maxCount = 0;
        for (char ch : tasks) {
            int executeTimes = charCount.getOrDefault(ch, 0) + 1;
            charCount.put(ch, executeTimes);
            maxExecuteTimes = Math.max(maxExecuteTimes, executeTimes);
        }
        for (char ch : charCount.keySet()) {
            if (charCount.get(ch) == maxExecuteTimes) {
                maxCount += 1;
            }
        }
        return Math.max((maxExecuteTimes - 1) * (n + 1) + maxCount, tasks.length);
    }

    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        Solution s = new Solution();
        System.out.println(s.leastInterval(tasks, 2));
    }
}