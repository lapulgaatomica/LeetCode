package unaccepted;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BuddyStrings {
    public static void main(String[] args) {
        // https://leetcode.com/problems/buddy-strings/
        System.out.println(buddyStrings("ab", "ba"));
        System.out.println(!buddyStrings("ab", "ab"));
        System.out.println(buddyStrings("aa", "aa"));
        System.out.println(buddyStrings("aaaaaaabc", "aaaaaaacb"));
        System.out.println(buddyStrings("abab", "abab"));
        System.out.println(!buddyStrings("abcd", "abcd"));
        System.out.println(!buddyStrings("abab", "acaa"));
    }

    public static boolean buddyStrings(String s, String goal) {
        int numberOfDifferences = 0;
        int sumOfDifferences = 0;
        Map<Character, Integer> frequencyOfCharacters = new HashMap<>();

        if(s.length() != goal.length() || s.length() == 1){
            return false;
        }

        Set<Character> characterSet = new HashSet<>();


        for(int i = 0; i < s.length(); i++){
            char currentSCharacter = s.charAt(i);
            char currentGoalCharacter = goal.charAt(i);
            int difference = currentSCharacter - currentGoalCharacter;
            characterSet.add(currentSCharacter);
            characterSet.add(currentGoalCharacter);
            if(difference != 0){
                numberOfDifferences++;
            }
            sumOfDifferences += difference;
            frequencyOfCharacters.put(currentSCharacter, frequencyOfCharacters.getOrDefault(currentSCharacter, 0) + 1);
        }

        if ((sumOfDifferences == 0 && numberOfDifferences == 2)
                || (sumOfDifferences == 0 && characterSet.size() == 1)){
            return true;
        }else if( sumOfDifferences == 0 && numberOfDifferences == 0 && characterSet.size() >= 2 && s.length() > 2){
            for(int i : frequencyOfCharacters.values()){
                if(i > 1 ){
                    return true;
                }
            }
        }

        return false;
    }
}
