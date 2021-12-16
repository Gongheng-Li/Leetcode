import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        Map<Character, Double> variables = new HashMap<>();
        int equationNumber = 0;
        for (List<String> equation : equations) {
            char numerator = ' ', denominator = ' ';
            Set<Character> numeratorSet = new HashSet<>();
            Set<Character> denominatorSet = new HashSet<>();
            String numeratorString = equation.get(0);
            String denominatorString = equation.get(1);
            for (int i = 0; i < numeratorString.length(); i++) {
                numeratorSet.add(numeratorString.charAt(i));
            }
            for (int i = 0; i < denominatorString.length(); i++) {
                denominatorSet.add(denominatorString.charAt(i));
            }
            for (char ch : numeratorSet) {
                if (!denominatorSet.contains(ch)) {
                    numerator = ch;
                    break;
                }
            }
            for (char ch : denominatorSet) {
                if (!numeratorSet.contains(ch)) {
                    denominator = ch;
                    break;
                }
            }
            if (variables.containsKey(numerator)) {
                variables.put(denominator, variables.get(numerator) / values[equationNumber]);
            } else if (variables.containsKey(denominator)) {
                variables.put(numerator, variables.get(denominator) * values[equationNumber]);
            } else {
                variables.put(denominator, 1.0);
                variables.put(numerator, values[equationNumber]);
            }
            equationNumber += 1;
        }
        int queryNumber = 0;
        for (List<String> query : queries) {
            int numerator = 1, denominator = 1;
            
        }
        return result;
    }
}