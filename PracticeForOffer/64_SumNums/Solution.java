class Solution {
    public int sumNums(int n) {
        boolean flag = n > 1 && (n += sumNums(n - 1)) > 0;
        return n;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.sumNums(9));
        System.out.println(s.sumNums(3));
        System.out.println(s.sumNums(1));
        System.out.println(s.sumNums(0));
    }
}