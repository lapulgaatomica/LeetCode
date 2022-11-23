package recursion;

import java.util.HashMap;
import java.util.Map;

public class ClimbStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(2));//1+1,2
        System.out.println(climbStairs(3));//1+1+1,1+2,2+1
        System.out.println(climbStairs(4));//1+1+1+1,1+1+2,1+2+1,2+1+1,2+2
        System.out.println(climbStairs(37));
    }

    public static int climbStairs(int n) {
        return climbStairs(n, new HashMap<>());
    }

    public static int climbStairs(int n, Map<Integer, Integer> map) {
        int result;
        if(map.containsKey(n))
            return map.get(n);
        if(n <= 2)
            result = n;
        else
            result = climbStairs(n - 1, map) + climbStairs(n - 2, map);
        map.put(n, result);
        return result;
    }
}
