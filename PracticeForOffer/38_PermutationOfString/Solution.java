import java.util.HashSet;
import java.util.Set;

class Solution {
    public static String[] permutation(String s) {
        if (s == null) {
            return new String[0];
        }
        if (s.length() == 1) {
            return new String[]{s};
        }
        Set<String> resultSet = new HashSet<>();
//        String[] resultArray = new String[factorial(s.length())];
//        int resultArrayIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            StringBuilder mutableString = new StringBuilder(s);
            mutableString.deleteCharAt(i);
            String[] permutedRest = permutation(mutableString.toString());
            for (String str : permutedRest) {
                String catenated = ch + str;
//                resultArray[resultArrayIndex] = catenated;
                resultSet.add(catenated);
//                resultArrayIndex += 1;
            }
        }
        return resultSet.toArray(new String[0]);
    }

    private static int factorial(int n) {
        int result = 1;
        while (n > 0) {
            result *= n;
            n -= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        permutation("abc");
    }
}