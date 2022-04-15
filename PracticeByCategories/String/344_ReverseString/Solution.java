import java.util.Arrays;

class Solution {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
    }

    public static void main(String[] args) {
        char[] string = {'S', 't', 'r', 'i', 'n', 'g'};
        Solution s = new Solution();
        s.reverseString(string);
        System.out.println(Arrays.toString(string));
    }
}