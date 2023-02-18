package greedy;

import java.util.Arrays;

public class MinimumHealth {
    public static void main(String[] args) {
        System.out.println(minimumHealth(new int[]{2,7,4,3}, 4) == 13);
        System.out.println(minimumHealth(new int[]{2,5,3,4}, 7) == 10);
        System.out.println(minimumHealth(new int[]{3,3,3}, 0) == 10);
        System.out.println(minimumHealth(new int[]{6,6,6,6}, 3) == 22);
        System.out.println(minimumHealth(new int[]{3}, 1) == 3);
        System.out.println(minimumHealth(new int[]{0,4,3,0,0}, 1) == 7);
    }

    public static long minimumHealth(int[] damage, int armor) {
        int maxDamage = 0;
        long totalDamage = 0;

        for (int d : damage) {
            totalDamage += d;
            maxDamage = Math.max(maxDamage, d);
        }

        return totalDamage - Math.min(armor, maxDamage) + 1;
    }
}
