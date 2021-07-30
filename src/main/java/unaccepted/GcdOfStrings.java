package unaccepted;

import java.util.*;
import java.util.stream.Collectors;

public class GcdOfStrings {
    public static void main(String[] args) {
        // https://leetcode.com/problems/greatest-common-divisor-of-strings/
        System.out.println(gcdOfStrings("ABCABC", "ABC"));
        System.out.println(gcdOfStrings("ABABAB", "ABAB"));
        System.out.println(gcdOfStrings("LEET", "CODE"));
        System.out.println(gcdOfStrings("ABCDEF", "ABC"));
        System.out.println(gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX",
                "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));
    }

    public static String gcdOfStrings(String str1, String str2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for(char c : str1.toCharArray()){
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }

        for(char c : str2.toCharArray()){
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        int min = Collections.min(map2.values());

        for(char c : map1.keySet()){
            if(!(map2.containsKey(c))){
                return "";
            }else{
                map2.put(c, map2.get(c)/min);
            }
        }

        StringBuilder answer = new StringBuilder();
        for(char c: str2.toCharArray()){
            if(map2.isEmpty()){
                break;
            }
            if(map2.containsKey(c)){
                if(map2.get(c) > 1){
                    answer.append(c);
                    map2.put(c, map2.get(c) -1);
                }else{
                    answer.append(c);
                    map2.remove(c);
                }
            }
        }
        return answer.toString();
    }
}
