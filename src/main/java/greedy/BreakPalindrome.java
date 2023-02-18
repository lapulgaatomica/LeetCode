package greedy;

import java.util.Set;
import java.util.TreeSet;

public class BreakPalindrome {
    public static void main(String[] args) {
//        System.out.println(breakPalindrome("abccba"));
//        System.out.println(breakPalindrome("a"));
//        System.out.println(breakPalindrome("aa"));
        System.out.println(breakPalindrome("aba"));
    }

    public static String breakPalindrome(String palindrome) {
        if(palindrome.length() == 1)
            return "";
        StringBuilder stringBuilder = new StringBuilder(palindrome);
        Set<String> set = new TreeSet<>();
        for(int i = 0; i < stringBuilder.length(); i++){
            if(palindrome.charAt(i) != 'a'){
                stringBuilder.replace(i,i+1, "a");
                if(isPalindrome(stringBuilder.toString()))
                    continue;
                return stringBuilder.toString();
            }else{
                StringBuilder temp = new StringBuilder(palindrome);
                temp.replace(i, i + 1, "b");
                String tempString = temp.toString();
                if(!isPalindrome(tempString))
                    set.add(temp.toString());
            }
        }
        return set.stream().findFirst().orElse("");
    }

    private static boolean isPalindrome(String string){
        int leftPointer = 0;
        int rightPointer = string.length() - 1;

        while (leftPointer < rightPointer){
            if(string.charAt(leftPointer) != string.charAt(rightPointer))
                return false;
            leftPointer++;
            rightPointer--;
        }
        return true;
    }
}
