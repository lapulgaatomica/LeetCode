package easy4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LengthOfLongestSubstring {
    //https://leetcode.com/problems/longest-substring-without-repeating-characters/
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstringLeetcode3("pwwkew"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> dump = new HashSet<>();
        int lengthOfLongestSubstring = 0;
        int left = 0;
        int right = 0;
        while (right < s.length()){
            char currentChar = s.charAt(right);
            if(!dump.add(currentChar)){
                while (s.charAt(left) != currentChar){
                    left++;
                }
                left++;
                lengthOfLongestSubstring = Math.max(lengthOfLongestSubstring, dump.size());
                right = left;
                dump = new HashSet<>();
            }else{
                right++;
            }
        }

        return Math.max(lengthOfLongestSubstring, dump.size());
    }

    public static int lengthOfLongestSubstringLeetcode1(String s) {
        int[] chars = new int[128];
        int left = 0;
        int right = 0;
        int res = 0;

        while (right < s.length()){
            char r = s.charAt(right);
            chars[r]++;

            while (chars[r] > 1){
                char l = s.charAt(left);
                chars[l]--;
                left++;
            }

            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }

    public static int lengthOfLongestSubstringLeetcode2(String s) {
        Integer[] chars = new Integer[128];
        int left = 0;
        int right = 0;
        int res = 0;

        while (right < s.length()){
            char r = s.charAt(right);
            Integer index = chars[r];
            if(index != null && index >= left && index < right)
                left = index + 1;

            res = Math.max(res, right - left + 1);
            chars[r] = right;
            right++;
        }
        return res;
    }

    public static int lengthOfLongestSubstringLeetcode3(String s) {
        int n = s.length(), ans = 0;

        Map<Character, Integer> map = new HashMap<>();
        for(int j = 0, i = 0; j < n; j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
}
