package easy3;

import java.util.ArrayList;
import java.util.List;

public class FindTheDifference {
    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde"));
        System.out.println(findTheDifference("abcd", "abecd"));
        System.out.println(findTheDifference("", "a"));
    }

    public static char findTheDifference(String s, String t) {
        if(s.length() == 0){
            return t.charAt(0);
        }

        List<Character> characterList = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != t.charAt(i)){
                if(characterList.contains(s.charAt(i))){
                    characterList.remove(characterList.indexOf(s.charAt(i)));
                }else{
                    characterList.add(s.charAt(i));
                }
                if(characterList.contains(t.charAt(i))){
                    characterList.remove(characterList.indexOf(t.charAt(i)));
                }else{
                    characterList.add(t.charAt(i));
                }
            }
        }

        if(characterList.isEmpty()){
            return t.charAt(s.length());
        }else{
            characterList.remove(characterList.indexOf(t.charAt(s.length())));
            return characterList.get(0);
        }
    }
}
