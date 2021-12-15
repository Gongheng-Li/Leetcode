import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((Object o1, Object o2) -> {
            return frequency.get(o1) - frequency.get(o2);
        });
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        int[] uniqueNums = new int[frequency.size()];
        int i = 0;
        for (int key : frequency.keySet()) {
            uniqueNums[i] = key;
            i += 1;
        }
//        int[] uniqueNums = {5, 3, 4, 8, 1, 6, 9, 2, 7};
        int left = 0, right = uniqueNums.length - 1;
        while (left <= right) {
            int settledPosition = partition(uniqueNums, left, right, frequency);
            if (settledPosition > k) {
                right = settledPosition - 1;
            } else if (settledPosition < k) {
                left = settledPosition + 1;
            } else {
                break;
            }
        }
        int[] result = new int[k];
        System.arraycopy(uniqueNums, 0, result, 0, k);
        return result;
    }

    private int partition(int[] nums, int left, int right, Map<Integer, Integer> frequency) {
        Random random = new Random();
        swap(nums, left, left + random.nextInt(right - left + 1));
        int l = left + 1, r = right;
        while (l <= r) {
            while (l <= right) {
                if (frequency.get(nums[l]) <= frequency.get(nums[left])) {
                    break;
                }
                l += 1;
            }
            while (r >= left) {
                if (frequency.get(nums[r]) >= frequency.get(nums[left])) {
                    break;
                }
                r -= 1;
            }
            if (l > r) {
                break;
            }
            swap(nums, l, r);
            l += 1;
            r -= 1;
        }
        swap(nums, left, r);
        return r;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 3, 2};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.topKFrequent(nums, 2)));
    }
}