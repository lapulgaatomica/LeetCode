package easy;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
        System.out.println(isAnagram("ab", "a"));
    }

    public static boolean isAnagram(String s, String t) {
        //https://leetcode.com/problems/valid-anagram
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++)
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        for(int i = 0; i < t.length(); i++)
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);

        for(char ch : tMap.keySet())
            if(!sMap.containsKey(ch) || !tMap.get(ch).equals(sMap.get(ch))){
                return false;
            }else {
                sMap.remove(ch);
            }

        return sMap.isEmpty();
    }
}
