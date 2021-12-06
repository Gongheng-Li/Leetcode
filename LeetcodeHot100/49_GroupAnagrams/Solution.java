import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> groups = new HashMap<>();
        for (String str : strs) {
            char[] characters = str.toCharArray();
            Arrays.sort(characters);
            String sortedStr = Arrays.toString(characters);
            if (groups.containsKey(sortedStr)) {
                groups.get(sortedStr).add(str);
            } else {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(str);
                groups.put(sortedStr, newGroup);
            }
        }
        for (String str : groups.keySet()) {
            result.add(groups.get(str));
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = s.groupAnagrams(strs);
        System.out.println(result.toString());
//        for (List<String> group : result) {
//            System.out.println(group.toString());
//        }
    }
}