package easy1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueMorseCodeWords {
    public static void main(String[] args) {
        // https://leetcode.com/problems/unique-morse-code-words/
        System.out.println(uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }

    public static int uniqueMorseRepresentations(String[] words) {
        String[] morseCodes = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",
                ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",
                ".--","-..-","-.--","--.."};

        Set<String> morseRepresentationOfWords = new HashSet<>();

        for(String word: words){
            String currentMorse = "";

            for(Character character : word.toCharArray()){
                currentMorse += morseCodes[character - 'a'];
            }

            morseRepresentationOfWords.add(currentMorse);
        }

        return morseRepresentationOfWords.size();
    }
}
