import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        int[] uniqueNums = new int[frequency.size()];
        int i = 0;
        for (int num : frequency.keySet()) {
            uniqueNums[i] = num;
            i += 1;
        }
        int left = 0, right = uniqueNums.length - 1;
        int middle = 0;
        while (left <= right) {
            middle = partition(uniqueNums, left, right, frequency);
            if (middle > uniqueNums.length - k) {
                right = middle - 1;
            } else if (middle < uniqueNums.length - k) {
                left = middle + 1;
            } else {
                break;
            }
        }
        int[] result = new int[k];
        System.arraycopy(uniqueNums, middle, result, 0, k);
        return result;
    }

    private int partition(int[] nums, int start, int end, Map<Integer, Integer> frequency) {
        Random random = new Random();
        int partitionPos = start + random.nextInt(end - start + 1);
        swap(nums, start, partitionPos);
        int left = start + 1, right = end;
        while (true) {
            while (left <= end && frequency.get(nums[left]) < frequency.get(nums[start])) {
                left += 1;
            }
            while (right >= start + 1 && frequency.get(nums[right]) > frequency.get(nums[start])) {
                right -= 1;
            }
            if (left > right) {
                break;
            }
            swap(nums, left, right);
            left += 1;
            right -= 1;
        }
        swap(nums, start, right);
        return right;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3, 0, 1, 0};
        System.out.println(Arrays.toString(s.topKFrequent(nums, 1)));
    }
}