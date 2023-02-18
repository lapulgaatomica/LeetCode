package easy4;

import java.util.HashSet;
import java.util.Set;

public class CanPermutePalindrome {
    public static void main(String[] args) {
        System.out.println(canPermutePalindrome("code"));
        System.out.println(canPermutePalindrome("aab"));
        System.out.println(canPermutePalindrome("carerac"));
    }

    public static boolean canPermutePalindrome(String s) {
        if(s.length() == 1)
            return true;
        Set<Character> set = new HashSet<>();
        for(char ch : s.toCharArray()){
            if(set.contains(ch))
                set.remove(ch);
            else
                set.add(ch);
        }
        return set.size() <= 1;
    }
}
