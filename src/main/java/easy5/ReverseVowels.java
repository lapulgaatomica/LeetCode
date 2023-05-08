package easy5;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowels {
    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
        System.out.println(reverseVowels("leetcode"));
    }

    public static String reverseVowels(String s) {
        int left = 0;
        int right = s.length() - 1;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');vowels.add('e');vowels.add('i');vowels.add('o');vowels.add('u');
        vowels.add('A');vowels.add('E');vowels.add('I');vowels.add('O');vowels.add('U');
        StringBuilder answer = new StringBuilder(s);

        while(left < right){
            if(vowels.contains(s.charAt(left)) && vowels.contains(s.charAt(right))){
                answer.setCharAt(left, s.charAt(right));
                answer.setCharAt(right, s.charAt(left));
                left++;
                right--;
            }else if(vowels.contains(s.charAt(left)) && !vowels.contains(s.charAt(right)))
                right--;
            else if(!vowels.contains(s.charAt(left)) && vowels.contains(s.charAt(right)))
                left++;
            else {
                left++;
                right--;
            }
        }
        return answer.toString();
    }
}
