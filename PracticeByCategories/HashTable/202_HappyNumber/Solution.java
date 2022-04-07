import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> rememberedSet = new HashSet<>();
        while (n != 1) {
            int temp = 0;
            while (n > 0) {
                temp += (n % 10) * (n % 10);
                n /= 10;
            }
            if (rememberedSet.contains(temp)) {
                return false;
            }
            rememberedSet.add(temp);
            n = temp;
        }
        return true;
    }
}