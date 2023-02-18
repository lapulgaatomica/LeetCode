package greedy;

import java.util.*;

public class CanCompleteCircuit {
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));
        System.out.println(canCompleteCircuit(new int[]{2,3,4}, new int[]{3, 4, 3}));
        System.out.println(canCompleteCircuit(new int[]{5,1,2,3,4}, new int[]{4,4,1,5,1}));
        System.out.println(canCompleteCircuit(new int[]{3,3,4}, new int[]{3,4,4}));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        int totalTank = 0;
        int currTank = 0;
        int startingStation = 0;
        for (int i = 0; i < n; ++i) {
            totalTank += gas[i] - cost[i];
            currTank += gas[i] - cost[i];
            // If one couldn't get here,
            if (currTank < 0) {
                // Pick up the next station as the starting one.
                startingStation = i + 1;
                // Start with an empty tank.
                currTank = 0;
            }
        }
        return totalTank >= 0 ? startingStation : -1;
    }
}
