package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class NumDecodings {
    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("226"));
        System.out.println(numDecodings("06"));
        System.out.println(numDecodings("11106"));
    }

    static Map<Integer, Integer> memo = new HashMap<>();

    public static int numDecodings(String s) {
        return dp(0, s);
    }

    private static int dp(int index, String s) {
        if(memo.containsKey(index))
            return memo.get(index);
        if(index == s.length())
            return 1;
        if(s.charAt(index) == '0')
            return 0;
        if(index == s.length() - 1)
            return 1;
        int ans = dp(index + 1, s);
        if(Integer.parseInt(s.substring(index, index + 2)) <= 26)
            ans += dp(index + 2, s);
        memo.put(index, ans);
        return ans;
    }
}
