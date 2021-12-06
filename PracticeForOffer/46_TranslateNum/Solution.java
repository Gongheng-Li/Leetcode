import java.util.LinkedList;

class Solution {
    public int translateNum(int num) {
        LinkedList<Integer> digitList= new LinkedList<>();
        while (num > 0) {
            digitList.addFirst(num % 10);
            num /= 10;
        }
        return translateDigitList(digitList);
    }

    private int translateDigitList(LinkedList<Integer> num) {
        if (num.size() == 0) {
            return 1;
        } else if (num.size() == 1) {
            return 1;
        }
        int firstDigit = num.removeFirst();
        int result = translateDigitList(num);
        if (firstDigit == 1 || firstDigit == 2 && num.getFirst() < 6) {
            int secondDigit = num.removeFirst();
            result += translateDigitList(num);
            num.addFirst(secondDigit);
        }
        num.addFirst(firstDigit);
        return result;
    }
}