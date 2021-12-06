class Solution {
    public int[] constructArr(int[] a) {
        int len = a.length;
        int[] leftHalf = new int[len];
        int[] rightHalf = new int[len];
        int[] result = new int[len];
        if (len == 0) {
            return result;
        }
        leftHalf[0] = 1;
        rightHalf[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            leftHalf[i] = leftHalf[i - 1] * a[i - 1];
            rightHalf[len - 1 - i] = rightHalf[len - i] * a[len - i];
        }
        for (int i = 0; i < len; i++) {
            result[i] = leftHalf[i] * rightHalf[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {1, 2, 3, 4, 5};
        int[] result = s.constructArr(a);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}