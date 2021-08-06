package easy1;

import java.util.HashMap;
import java.util.Map;

public class CountCharacters {
    public static void main(String[] args) {
        // https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
        System.out.println(countCharacters(new String[]{"cat","tb","hat","tree"}, "atach"));
        System.out.println(countCharacters(new String[]{"hello","world","leetcode"}, "welldonehoneyr"));
    }

    public static int countCharacters(String[] words, String chars) {
        int answer = 0;
        Map<Character, Integer> frequencyOfChars = new HashMap<>();
        for(char c: chars.toCharArray()){
            frequencyOfChars.put(c, frequencyOfChars.getOrDefault(c, 0) + 1);
        }

        for(String word : words){
            int flag = 0;
            Map<Character, Integer> frequencyOfCharsInWord = new HashMap<>();

            for(char c: word.toCharArray()){
                frequencyOfCharsInWord.put(c, frequencyOfCharsInWord.getOrDefault(c, 0) + 1);
            }

            for(char c: frequencyOfCharsInWord.keySet()){
                if(frequencyOfCharsInWord.get(c) > frequencyOfChars.getOrDefault(c, 0)){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                answer += word.length();
            }
        }

        return answer;
    }
}
