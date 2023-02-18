package easy4;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {
    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("foo", "bar"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("badc", "baba"));
    }

    public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            if(map.containsKey(sChar)){
              if(!map.get(sChar).equals(tChar))
                  return false;
            }else{
                if(map.containsValue(tChar))
                    return false;
                else
                    map.put(sChar, tChar);
            }

        }
        return true;
    }
}
