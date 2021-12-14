import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((Object o1, Object o2) -> {
            return frequency.get(o1) - frequency.get(o2);
        });
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        for (int key : frequency.keySet()) {
            if (heap.size() < k) {
                heap.add(key);
            } else {
                if (frequency.get(key) > frequency.get(heap.peek())) {
                    heap.poll();
                    heap.add(key);
                }
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = heap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 3, 2};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.topKFrequent(nums, 2)));
    }
}