class Solution {
    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                result.append(s.charAt(i));
            } else {
                int repeatTimes = 0;
                while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    repeatTimes = repeatTimes * 10 + s.charAt(i) - '0';
                    i += 1;
                }
                result.append(decodeRepeatPart(s, i, repeatTimes));
                i = skipRepeatPart(s, i);
            }
        }
        return result.toString();
    }

    private StringBuilder decodeRepeatPart(String s, int begin, int repeatTimes) {
        StringBuilder repeatPart = new StringBuilder();
        for (int i = begin + 1; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                break;
            } else if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                int innerRepeatTimes = 0;
                while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    innerRepeatTimes = innerRepeatTimes * 10 + s.charAt(i) - '0';
                    i += 1;
                }
                repeatPart.append(decodeRepeatPart(s, i, innerRepeatTimes));
                i = skipRepeatPart(s, i);
            } else {
                repeatPart.append(s.charAt(i));
            }
        }
        StringBuilder result = new StringBuilder();
        result.append(String.valueOf(repeatPart).repeat(repeatTimes));
        return result;
    }

    private int skipRepeatPart(String s, int begin) {
        int ptr = begin;
        int count = 1;
        while (count > 0) {
            ptr += 1;
            if (s.charAt(ptr) == '[') {
                count += 1;
            } else if (s.charAt(ptr) == ']') {
                count -= 1;
            }
        }
        return ptr;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.decodeString("100[leetcode]"));
    }
}