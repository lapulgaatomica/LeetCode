package easy3;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println(longestPalindromeLeetcodeSolution("abccccdd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("bb"));
        System.out.println(longestPalindrome("bbbccc"));
        System.out.println(longestPalindrome("bacc"));
    }

    public static int longestPalindrome(String s) {
        if(s.length() == 1)
            return 1;

        Map<Character, Integer> map = new HashMap<>();
        boolean singleCharExists = false;
        int longestPalindrome = 0;

        for(char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        for(int frequency : map.values()){
            if(frequency % 2 == 0)
                longestPalindrome += frequency;
            else{
                if(frequency == 1){
                    if(!singleCharExists){
                        longestPalindrome += frequency;
                        singleCharExists = true;
                    }
                }else {
                    if(!singleCharExists){
                        longestPalindrome += frequency;
                        singleCharExists = true;
                    }else {
                        longestPalindrome += (frequency - 1);
                    }
                }
            }
        }
        return longestPalindrome;
    }

    public static int longestPalindromeLeetcodeSolution(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1)
                ans++;
        }
        return ans;
    }
}
