package unaccepted;

import java.util.*;

public class CommonChars {
    public static void main(String[] args) {
        //https://leetcode.com/problems/find-common-characters/
        System.out.println(commonChars(new String[]{"bella","label","roller"}));
        System.out.println(commonChars(new String[]{"cool","lock","cook"}));
    }

    public static List<String> commonChars(String[] words) {
        Map<Character, Integer> answerMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Map<Character, Integer> temp = new HashMap<>();
            for (char ch : word.toCharArray()) {
                if(i == 0){
                    answerMap.put(ch, answerMap.getOrDefault(ch, 0) + 1);
                }else{
                    temp.put(ch, temp.getOrDefault(ch, 0) + 1);
                }
            }
            if(i != 0){
                for(char key : words[0].toCharArray()){
                    if(!temp.containsKey(key)){
                        answerMap.remove(key);
                    }else{
                        if(temp.get(key) < answerMap.get(key)){
                            answerMap.put(key, temp.get(key));
                        }
                    }
                }
            }
        }
        List<String> answer = new ArrayList<>();
        for (char c : answerMap.keySet()){
            for (int i = 0; i < answerMap.get(c); i++){
                answer.add(String.valueOf(c));
            }
        }
        return answer;
    }
}
