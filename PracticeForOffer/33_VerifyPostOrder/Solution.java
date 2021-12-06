class Solution {
    public static boolean verifyPostorder(int[] postorder) {
        return verifyPostorderHelper(postorder, 0, postorder.length - 1);
    }

    private static boolean verifyPostorderHelper(int[] postorder, int startIndex, int endIndex) {
        if (endIndex - startIndex <= 1) {
            return true;
        }
        boolean enterLeftTreeFlag = false;
        int root = postorder[endIndex];
        int centerIndex = startIndex - 1;
        for (int i = endIndex - 1; i >= startIndex; i--) {
            if (enterLeftTreeFlag && postorder[i] >= root) {
                return false;
            }
            if (!enterLeftTreeFlag && postorder[i] < root) {
                enterLeftTreeFlag = true;
                centerIndex = i;
            }
        }
        return verifyPostorderHelper(postorder, startIndex, centerIndex)
                && verifyPostorderHelper(postorder, centerIndex + 1, endIndex - 1);
    }

    public static void main(String[] args) {
        int[] testArray = {1,2,5,10,6,9,4,3};
        System.out.println(verifyPostorder(testArray));
    }
}