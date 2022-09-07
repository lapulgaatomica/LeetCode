package freestyle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Freestyle {
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
            if(map.containsKey(charsString)){
                map.get(charsString).add(str);
            }else{
                List<String> innerList = new ArrayList<>();
                innerList.add(str);
                map.put(charsString, innerList);
            }
        }
        return new ArrayList<>(map.values());
    }
}
