import java.util.HashMap;
import java.util.Map;

class Solution {
    public char firstUniqChar(String s) {
        Map<Character, Integer> frequency = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char thisCharacter = s.charAt(i);
            if (frequency.containsKey(thisCharacter)) {
                frequency.put(thisCharacter, frequency.get(thisCharacter) + 1);
            } else {
                frequency.put(thisCharacter, 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char thisCharacter = s.charAt(i);
            if (frequency.get(thisCharacter) == 1) {
                return thisCharacter;
            }
        }
        return ' ';
    }
}