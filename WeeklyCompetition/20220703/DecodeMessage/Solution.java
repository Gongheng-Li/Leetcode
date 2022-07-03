class Solution {
    public String decodeMessage(String key, String message) {
        int[] dict = new int[26];
        int keyLength = key.length();
        int count = 1;
        for (int i = 0; i < keyLength; i++) {
            char ch = key.charAt(i);
            if (ch != ' ' && dict[ch - 'a'] == 0) {
                dict[ch - 'a'] = count;
                count += 1;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int messageLength = message.length();
        for (int i = 0; i < messageLength; i++) {
            char ch = message.charAt(i);
            if (ch == ' ') {
                stringBuilder.append(' ');
            } else {
                stringBuilder.append((char) (dict[ch - 'a'] - 1 + 'a'));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
    }
}