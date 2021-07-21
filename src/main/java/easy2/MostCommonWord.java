package easy2;

import java.util.*;

public class MostCommonWord {
    // https://leetcode.com/problems/most-common-word/
    public static void main(String[] args) {
        System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
        System.out.println(mostCommonWord("a, a, a, a, b,b,b,c, c", new String[]{"a"}));
//        System.out.println(Arrays.toString("a, a, a, a, b,b,b,c, c".split("[^a-zA-Z]")));
//        System.out.println(Arrays.toString("Bob hit a ball, the hit BALL flew far after it was hit.".toLowerCase().split("[^a-zA-Z]")));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph
                .toLowerCase()
                .split("[^a-zA-Z]");

        Map<String, Integer> wordsFrequency = new HashMap<>();
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        String mostCommonWord = "";
        int frequencyOfMostCommonWord = 0;

        for(String word : words){
            if(!word.isBlank()  && !bannedSet.contains(word)){
                wordsFrequency.put(word, wordsFrequency.getOrDefault(word, 0) + 1);
            }
        }

//        System.out.println(wordsFrequency);

        for(String key: wordsFrequency.keySet()){
            if(wordsFrequency.get(key) > frequencyOfMostCommonWord){
                frequencyOfMostCommonWord = wordsFrequency.get(key);
                mostCommonWord = key;
            }
        }

        return Collections.max(wordsFrequency.entrySet(), Map.Entry.comparingByValue()).getKey();

//        return mostCommonWord;
    }
}
