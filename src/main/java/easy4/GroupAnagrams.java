package easy4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            char[] chars = new char[26];
            for(char ch : str.toCharArray()){
                chars[ch - 'a']++;
            }
            String charsString = new String(chars);
            if(!map.containsKey(charsString))
                map.put(charsString, new ArrayList<>());
            map.get(charsString).add(str);
        }

         return new ArrayList<>(map.values());
    }
}
