package unaccepted.youtubesolutions;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        System.out.println(groupAnagrams(new String[]{""}));
        System.out.println(groupAnagrams(new String[]{"", ""}));
        System.out.println(groupAnagrams(new String[]{"a"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            char[] hash = new char[26];
            for(char ch : str.toCharArray()){
                hash[ch - 'a']++;
            }
            String hashString = new String(hash);
            if(map.get(hashString) == null){
                map.put(hashString, new ArrayList<>());
            }
            map.get(hashString).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
