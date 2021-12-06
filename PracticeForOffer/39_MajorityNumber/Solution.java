class Solution {
    public static int majorityElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int middle = (start + end) / 2;
        int fixedNumber = partition(nums, start, end);
        while (fixedNumber != middle) {
            if (fixedNumber > middle) {
                end = fixedNumber - 1;
            } else {
                start = fixedNumber + 1;
            }
            fixedNumber = partition(nums, start, end);
        }
        return nums[fixedNumber];
    }

    private static int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int pivotPos = start;
        start += 1;
        while (start <= end) {
            if (nums[start] >= pivot) {
                while (nums[end] > pivot) {
                    end -= 1;
                    if (end < start) {
                        break;
                    }
                }
                if (start <= end) {
                    swap(nums, start, end);
                    end -= 1;
                }
            }
            start += 1;
        }
        swap(nums, pivotPos, end);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        return end;
    }

    private static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void main(String[] args) {
        int[] testArray = {2, 2, 1, 1, 1, 2, 2};
        int majorityNum = majorityElement(testArray);
    }
}