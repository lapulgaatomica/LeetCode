package recursion;

import java.util.HashMap;
import java.util.Map;

public class Fib {
    static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(fib(4));
    }

    public static int fib(int n) {
        return fib(n, new HashMap<>());
    }

    public static int fib(int n, Map<Integer, Integer> map) {
        if(map.containsKey(n))
            return map.get(n);
        int result;
        if(n < 2)
            result = n;
        else
            result = fib(n - 2, map) + fib(n - 1, map);
        map.put(n, result);
        return result;
    }
}
