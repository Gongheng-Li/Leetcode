import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] count = new int[26];
        int sLength = s.length();
        for (int i = 0; i < sLength; i++) {
            count[s.charAt(i) - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int end = 0;
        while (end < sLength) {
            int partLength = 0;
            for (int i = end; i <= end; i++) {
                int newEnd = count[s.charAt(i) - 'a'];
                if (end < newEnd) {
                    end = newEnd;
                }
                partLength += 1;
            }
            result.add(partLength);
            end += 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.partitionLabels("ababcbacadefegdehijhklij"));
    }
}