package dynamicprogramming;

import java.util.HashMap;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{10,15,20}));
        System.out.println(minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
        System.out.println(minCostClimbingStairs(new int[]{0, 1, 1, 0}));
    }

    public static int minCostClimbingStairs(int[] cost) {
        return minimumCost(cost.length, cost, new HashMap<>());
    }

    private static int minimumCost(int i, int[] cost, HashMap<Integer, Integer> memo) {
        // Base case, we are allowed to start at either step 0 or step 1
        if (i <= 1)
            return 0;

        // Check if we have already calculated minimumCost(i)
        if (memo.containsKey(i))
            return memo.get(i);

        // If not, cache the result in our hash map and return it
        int downOne = cost[i - 1] + minimumCost(i - 1, cost, memo);
        int downTwo = cost[i - 2] + minimumCost(i - 2, cost, memo);
        memo.put(i, Math.min(downOne, downTwo));
        return memo.get(i);
    }
}
