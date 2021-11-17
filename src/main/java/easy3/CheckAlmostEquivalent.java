package easy3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheckAlmostEquivalent {
    //https://leetcode.com/problems/check-whether-two-strings-are-almost-equivalent/
    public static void main(String[] args) {
        System.out.println(checkAlmostEquivalent("aaaa", "bccb"));
        System.out.println(checkAlmostEquivalent("abcdeef", "abaaacc"));
        System.out.println(checkAlmostEquivalent("cccddabba", "babababab"));
    }

    public static boolean checkAlmostEquivalent(String word1, String word2) {
        Set<Character> everyLetter = new HashSet<>();
        Map<Character, Integer> word1CharMap = new HashMap<>();
        Map<Character, Integer> word2CharMap = new HashMap<>();

        for(char c: word1.toCharArray()){
            everyLetter.add(c);
            word1CharMap.put(c, word1CharMap.getOrDefault(c, 0) + 1);
        }

        for(char c: word2.toCharArray()){
            everyLetter.add(c);
            word2CharMap.put(c, word2CharMap.getOrDefault(c, 0) + 1);
        }

        for(char c : everyLetter){
            int freqInWord1 = word1CharMap.getOrDefault(c, 0);
            int freqInWord2 = word2CharMap.getOrDefault(c, 0);

            if(Math.abs(freqInWord1 - freqInWord2) > 3){
                return false;
            }
        }
        return true;
    }
}
