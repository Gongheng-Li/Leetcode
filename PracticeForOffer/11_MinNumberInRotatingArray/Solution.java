class Solution {
    public static int minArray(int[] numbers) {
        return minArrayHelper(numbers, 0, numbers.length - 1);
    }

    private static int minArrayHelper(int[] numbers, int start, int end) {
        if (start == end) {
            return numbers[start];
        }
        int middle = (start + end) / 2;
        if (numbers[middle] == numbers[start] && numbers[middle] == numbers[end]) {
            return minArrayHelper(numbers, start + 1, end);
        } else if (numbers[middle] >= numbers[start] && numbers[middle] > numbers[end]) {
            return minArrayHelper(numbers, middle + 1, end);
        } else if (numbers[middle] < numbers[start] && numbers[middle] <= numbers[end]) {
            return minArrayHelper(numbers, start, middle);
        } else {
            return numbers[start];
        }
    }
}