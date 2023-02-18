package dynamicprogramming;

import java.util.HashMap;

public class Tribonacci {
    public static void main(String[] args) {
        System.out.println(tribonacci(4));
        System.out.println(tribonacci(5));
        System.out.println(tribonacci(31));
        System.out.println(tribonacci(33));
    }

    public static int tribonacci(int n) {
        return dp(n, new HashMap<>());
    }

    private static int dp(int n, HashMap<Integer, Integer> map){
        if(map.containsKey(n))
            return map.get(n);
        if(n == 0)
            return 0;
        if(n <= 2)
            return 1;
        int res = dp(n - 1, map) + dp(n - 2, map) + dp(n - 3, map);
        map.put(n, res);
        return map.get(n);
    }
}
