class Solution {
    public boolean isNumber(String s) {
        int ptr = 0;
        try {
            while (s.charAt(ptr) == ' ') {
                ptr += 1;
            }
            if (s.charAt(ptr) == '+' || s.charAt(ptr) == '-') {
                ptr += 1;
            }
            if (s.charAt(ptr) == 'e' || s.charAt(ptr) == 'E' || s.charAt(ptr) == '.' && (s.charAt(ptr + 1) < '0' || s.charAt(ptr + 1) > '9')) {
                return false;
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
        try {
            boolean dotFlag = false;
            while (s.charAt(ptr) >= '0' && s.charAt(ptr) <= '9' || s.charAt(ptr) == '.') {
                if (s.charAt(ptr) == '.') {
                    if (dotFlag) {
                        return false;
                    } else {
                        dotFlag = true;
                    }
                }
                ptr += 1;
            }
        } catch (IndexOutOfBoundsException e) {
            return true;
        }
        if (s.charAt(ptr) != ' ' && s.charAt(ptr) != 'e' && s.charAt(ptr) != 'E') {
            return false;
        }
        if (s.charAt(ptr) == 'e' || s.charAt(ptr) == 'E') {
            ptr += 1;
            try {
                if (s.charAt(ptr) == '+' || s.charAt(ptr) == '-') {
                    ptr += 1;
                }
                if (s.charAt(ptr) > '9' || s.charAt(ptr) < '0') {
                    return false;
                }
            } catch (IndexOutOfBoundsException e) {
                return false;
            }
            try {
                while (s.charAt(ptr) >= '0' && s.charAt(ptr) <= '9') {
                    ptr += 1;
                }
            } catch (IndexOutOfBoundsException e) {
                return true;
            }
        }
        try {
            while (s.charAt(ptr) == ' ') {
                ptr += 1;
            }
        } catch (IndexOutOfBoundsException e) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("These should be true:");
        System.out.println(s.isNumber("+100"));
        System.out.println(s.isNumber("5e2"));
        System.out.println(s.isNumber("-123"));
        System.out.println(s.isNumber("3.1416"));
        System.out.println(s.isNumber("-1E-16"));
        System.out.println(s.isNumber("0123"));
        System.out.println("These should be false:");
        System.out.println(s.isNumber("12e"));
        System.out.println(s.isNumber("1a3.14"));
        System.out.println(s.isNumber("1.2.3"));
        System.out.println(s.isNumber("+-5"));
        System.out.println(s.isNumber("12e+5.4"));
    }
}