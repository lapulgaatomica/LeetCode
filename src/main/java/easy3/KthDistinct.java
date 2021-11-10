package easy3;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class KthDistinct {
    public static void main(String[] args) {
        //https://leetcode.com/problems/kth-distinct-string-in-an-array/
        System.out.println(kthDistinct(new String[]{"d","b","c","b","c","a"}, 2));
        System.out.println(kthDistinct(new String[]{"aaa","aa","a"}, 1));
        System.out.println(kthDistinct(new String[]{"a","b","a"}, 3));
    }

    public static String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new LinkedHashMap<>();//LinkedHashMap keeps the insertion order of the key
        for(String ar : arr){
            map.put(ar, map.getOrDefault(ar, 0) + 1);
        }

        for(String key : map.keySet()){
            if(map.get(key) == 1){
                k -= 1;
                if(k == 0){
                    return key;
                }
            }
        }

        return "";
    }
}
