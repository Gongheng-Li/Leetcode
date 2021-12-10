class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int tailsLength = 0;
        for (int num : nums) {
            if (tailsLength == 0 || num > tails[tailsLength - 1]) {
                tails[tailsLength] = num;
                tailsLength += 1;
            } else {
                binarySearchAndReplace(tails, tailsLength, num);
            }
        }
        return tailsLength;
    }

    private void binarySearchAndReplace(int[] tails, int tailsLength, int target) {
        int l = 0, r = tailsLength - 1;
        while (true) {
            if (r - l <= 1) {
                if (tails[l] >= target) {
                    tails[l] = target;
                } else if (tails[r] >= target) {
                    tails[r] = target;
                } else {
                    tails[r + 1] = target;
                }
                break;
            }
            int middle = (l + r) / 2;
            if (tails[middle] > target) {
                r = middle - 1;
            } else if (tails[middle] < target) {
                l = middle + 1;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,2,3};
        Solution s = new Solution();
        System.out.println(s.lengthOfLIS(nums));
    }
}