package easy;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static void main(String[] args) {

        System.out.println(romanToInt("MCMXCIV"));

//        System.out.println(romanToInt("X"));
    }

    public static int romanToInt(String s) {
        Map<Character, Integer> romanNumerals = new HashMap<>();
        romanNumerals.put('I', 1);
        romanNumerals.put('V', 5);
        romanNumerals.put('X', 10);
        romanNumerals.put('L', 50);
        romanNumerals.put('C', 100);
        romanNumerals.put('D', 500);
        romanNumerals.put('M', 1000);

        int result = 0;
        int previousNumber;
        int currentNumber;
        int nextNumber;

        for(int i = 0; i < s.length(); i++){
            currentNumber = romanNumerals.get(s.charAt(i));

            if(i == s.length() - 1){
                nextNumber = 0;
            }else{
                nextNumber = romanNumerals.get(s.charAt(i + 1));
            }

            if(i == 0){
                previousNumber = 0;
            }else{
                previousNumber = romanNumerals.get(s.charAt(i - 1));
            }

            if(i == 0 && currentNumber < nextNumber){
                result -= currentNumber;
            }else if(currentNumber >= nextNumber || currentNumber >= previousNumber){
                result += currentNumber;
            }else if(currentNumber < nextNumber){
                result -= currentNumber;
            }
        }
        return result;
    }
}
