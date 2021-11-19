package easy3;

public class AreNumbersAscending {
    public static void main(String[] args) {
        //https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/
        System.out.println(areNumbersAscending("1 box has 3 blue 4 red 6 green and 12 yellow marbles"));
        System.out.println(areNumbersAscending("hello world 5 x 5"));
        System.out.println(areNumbersAscending("sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"));
        System.out.println(areNumbersAscending("4 5 11 26"));

        System.out.println();
    }

    public static boolean areNumbersAscending(String s) {
        String[] strings = s.split(" ");
        int previousNumber = 0;
        for(String string : strings){
            try{
                int currentNumber = Integer.parseInt(string);
                if(currentNumber <= previousNumber){
                    return false;
                }
                previousNumber = currentNumber;
            }catch (NumberFormatException ignored){
            }
        }
        return true;
    }
}
