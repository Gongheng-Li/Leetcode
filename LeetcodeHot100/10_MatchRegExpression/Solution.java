class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }

    private boolean isMatch(String s, String p, int sStart, int pStart) {
        int sPtr = sStart, pPtr = pStart;
        char former = ' ';
        while (sPtr < s.length() && pPtr < p.length()) {
            if (s.charAt(sPtr) == p.charAt(pPtr) || p.charAt(pPtr) == '.') {
                former = p.charAt(pPtr);
                sPtr += 1;
                pPtr += 1;
            } else if (p.charAt(pPtr) == '*') {
                if (former == '.') {
                    while (p.charAt(pPtr) == '*' || p.charAt(pPtr) == '.') {
                        pPtr += 1;
                        if (pPtr >= p.length()) {
                            return true;
                        }
                    }
                    char ch = p.charAt(pPtr);
                    while (sPtr < s.length()) {
                        if (s.charAt(sPtr) == ch && isMatch(s, p, sPtr, pPtr)) {
                            return true;
                        }
                        sPtr += 1;
                    }
                    return false;
                } else {
                    pPtr += 1;
                    int count = 0;
                    while (sPtr < s.length() && s.charAt(sPtr) == former) {
                        count += 1;
                        sPtr += 1;
                    }
                    while (pPtr < p.length()) {
                        if (p.charAt(pPtr) == former) {
                            count -= 1;
                            pPtr += 1;
                            if (pPtr < p.length() && p.charAt(pPtr) == '*') {
                                count += 1;
                                pPtr += 1;
                            }
                            if (count < 0) {
                                return false;
                            }
                        }
                    }
                }
//                pPtr += 1;
            } else if (pPtr + 1 < p.length() && p.charAt(pPtr + 1) == '*') {
                former = p.charAt(pPtr);
                pPtr += 2;
            } else {
                return false;
            }
        }
        while (pPtr < p.length() && p.charAt(pPtr) == '*') {
            pPtr += 1;
        }
        return sPtr >= s.length() && pPtr >= p.length();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isMatch("aaa", "ab*a*c*a"));
    }
}