import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder combination = new StringBuilder();
        recursion(n, 0, result, combination);
        return result;
    }

    private void recursion(int toPush, int toPop, List<String> result, StringBuilder combination) {
        if (toPush == 0 && toPop == 0) {
            result.add(combination.toString());
            return;
        }
        if (toPush != 0) {
            combination.append('(');
            recursion(toPush - 1, toPop + 1, result, combination);
            combination.deleteCharAt(combination.length() - 1);
        }
        if (toPop != 0) {
            combination.append(')');
            recursion(toPush, toPop - 1, result, combination);
            combination.deleteCharAt(combination.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> result = s.generateParenthesis(5);
        for (String str : result) {
            System.out.println(str);
        }
    }
}