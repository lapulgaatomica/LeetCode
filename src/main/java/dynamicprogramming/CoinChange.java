package dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(coinChange(new int[]{2}, 3));
        System.out.println(coinChange(new int[]{1}, 0));
    }

    static Map<Integer, Integer> memo = new HashMap<>();
    static int min = Integer.MAX_VALUE;

    public static int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return 0;
        Arrays.sort(coins);

        dp(0, 0, coins, amount);
        return min;
    }

    private static int dp(int current, int numCoins, int[] coins, int amount) {
        if(memo.containsKey(current))
            return memo.get(current);
        if(current >= amount) {
            if(current == amount && numCoins < min)
                min = numCoins;
            return current;
        }

        for(int i = 0; i < coins.length; i++) {
            int total = dp(current + coins[i], numCoins + 1, coins, amount);
            memo.put(current, total);
        }
        return memo.get(current);
    }
}
