class Solution {
    public int strToInt(String str) {
        int num = 0;
        int sign = 1;
        int ptr = 0;
        while (ptr < str.length()) {
            char thisCharacter = str.charAt(ptr);
            if (thisCharacter == ' ') {
                ptr += 1;
            } else if (thisCharacter == '-') {
                sign = -1;
                ptr += 1;
                break;
            }else if (thisCharacter == '+') {
                ptr += 1;
                break;
            } else if (thisCharacter >= '0' && thisCharacter <= '9') {
                break;
            } else {
                return 0;
            }
        }
        if (ptr > str.length()) {
            return 0;
        }
        while (ptr < str.length()) {
            char thisCharacter = str.charAt(ptr);
            if (thisCharacter < '0' || thisCharacter > '9') {
                break;
            } else {
                int digit = thisCharacter - '0';
                if (sign > 0) {
                    if (num > Integer.MAX_VALUE / 10 ||
                            (num == Integer.MAX_VALUE / 10 && digit >= Integer.MAX_VALUE % 10)) {
                        return Integer.MAX_VALUE;
                    }
                } else {
                    if (num * (-1) < Integer.MIN_VALUE / 10 ||
                            (num * (-1)) == Integer.MIN_VALUE / 10 && digit * (-1) <= Integer.MIN_VALUE % 10) {
                        return Integer.MIN_VALUE;
                    }
                }
                num = num * 10 + digit;
                ptr += 1;
            }
        }
        return num * sign;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.strToInt("42") == 42);
        System.out.println(s.strToInt("   42") == 42);
        System.out.println(s.strToInt("  -42") == -42);
        System.out.println(s.strToInt("42eggs") == 42);
        System.out.println(s.strToInt("it's 42") == 0);
        System.out.println(s.strToInt("-2147483649") == -2147483648);
        System.out.println(s.strToInt("") == 0);
    }
}