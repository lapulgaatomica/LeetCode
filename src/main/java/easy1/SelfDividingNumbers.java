package easy1;

import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public static void main(String[] args) {
        // https://leetcode.com/problems/self-dividing-numbers/
        System.out.println(selfDividingNumbers(1, 22));
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();

        for(int i = left; i <= right; i++){
            int currentNumber = i;
            while(true){
                if(currentNumber == 0){
                    result.add(i);
                    break;
                }
                int lastDigit = currentNumber % 10;

                if(lastDigit == 0 || i % lastDigit != 0){
                    break;
                }
                currentNumber = currentNumber / 10;
            }
        }
        return result;
    }
}
