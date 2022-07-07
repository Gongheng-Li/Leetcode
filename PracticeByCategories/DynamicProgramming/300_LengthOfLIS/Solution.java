import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tailOfLength = new int[nums.length];
        int maxLength = 0;
        for (int num : nums) {
            if (maxLength == 0 || num > tailOfLength[maxLength - 1]) {
                tailOfLength[maxLength] = num;
                maxLength += 1;
            } else {
                int left = 0, right = maxLength - 1;
                while (left <= right) {
                    int middle = (left + right) / 2;
                    if (tailOfLength[middle] >= num) {
                        right = middle - 1;
                    } else {
                        left = middle + 1;
                    }
                }
                tailOfLength[left] = num;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
//        int[] nums = {0, 1, 0, 3, 2, 3};
        int[] nums = {4, 10, 4, 3, 8, 9};
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLIS(nums));
    }
}