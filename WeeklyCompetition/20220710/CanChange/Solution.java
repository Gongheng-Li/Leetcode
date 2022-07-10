class Solution {
    public boolean canChange(String start, String target) {
        StringBuilder startBuilder = new StringBuilder();
        StringBuilder targetBuilder = new StringBuilder();
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != '_') {
                startBuilder.append(start.charAt(i));
            }
            if (target.charAt(i) != '_') {
                targetBuilder.append(target.charAt(i));
            }
        }
        if (!startBuilder.toString().equals(targetBuilder.toString())) {
            return false;
        }
        int i = 0, j = 0;
        while (i < start.length() && j < target.length()) {
            while (i < start.length() && start.charAt(i) == '_') {
                i += 1;
            }
            while (j < target.length() && target.charAt(j) == '_') {
                j += 1;
            }
            if (i == start.length() || j == target.length()) {
                break;
            }
            if (start.charAt(i) == 'L' && i < j || start.charAt(i) == 'R' && i > j) {
                return false;
            }
            i += 1;
            j += 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canChange("_L__R__R_", "L______RR"));
    }
}