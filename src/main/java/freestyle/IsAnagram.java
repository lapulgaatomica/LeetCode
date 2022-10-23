package freestyle;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for(char ch : s.toCharArray())
            sMap.put(ch, sMap.getOrDefault(ch, 0) + 1);

        for(char ch : t.toCharArray())
            tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);

        for(char key : sMap.keySet()){
            if(!tMap.containsKey(key) || !tMap.get(key).equals(sMap.get(key)))
                return false;
        }

        return true;
    }
}
