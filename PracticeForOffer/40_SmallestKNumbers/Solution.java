import java.util.PriorityQueue;

class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> smallestNumbers = new PriorityQueue<>();
        for (int num : arr) {
            if (smallestNumbers.size() >= k) {
                if (smallestNumbers.size() != 0 && smallestNumbers.peek() < -1 * num) {
                    smallestNumbers.poll();
                    smallestNumbers.add(-1 * num);
                }
            } else {
                smallestNumbers.add(-1 * num);
            }
        }
        int[] result = new int[k];
        int i = 0;
        for (int num : smallestNumbers) {
            result[i] = -1 * num;
            i += 1;
        }
        return result;
    }
}