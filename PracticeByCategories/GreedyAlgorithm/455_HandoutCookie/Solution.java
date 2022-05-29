import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gPtr = 0, sPtr = 0;
        while (gPtr < g.length && sPtr < s.length) {
            if (g[gPtr] <= s[sPtr]) {
                gPtr += 1;
            }
            sPtr += 1;
        }
        return gPtr;
    }

    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        Solution solution = new Solution();
        System.out.println(solution.findContentChildren(g, s));
    }
}