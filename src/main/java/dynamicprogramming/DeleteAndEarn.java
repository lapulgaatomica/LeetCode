package dynamicprogramming;

import java.util.*;

public class DeleteAndEarn {
    public static void main(String[] args) {
        System.out.println(deleteAndEarn(new int[]{2,2,3,3,3,4}));
        System.out.println(deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println(deleteAndEarn(new int[]{12,32,93,17,100,72,40,71,37,92,58,34,29,78,11,84,77,90,92,35,12,5,27,
                92,91,23,65,91,85,14,42,28,80,85,38,71,62,82,66,3,33,33,55,60,48,78,63,11,20,51,78,42,37,21,100,13,60,
                57,91,53,49,15,45,19,51,2,96,22,32,2,46,62,58,11,29,6,74,38,70,97,4,22,76,19,1,90,63,55,64,44,90,51,
                36,16,65,95,64,59,53,93}));
    }

    private static HashMap<Integer, Integer> points;
    private static HashMap<Integer, Integer> cache;
    public static int deleteAndEarn(int[] nums) {
        points = new HashMap<>();
        cache = new HashMap<>();
        int maxNumber = 0;
        for(int num : nums){
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }
        return maxPoints(maxNumber);
    }

    private static int maxPoints(int num) {
        if(num == 0)
            return 0;
        if(num == 1)
            return points.getOrDefault(1, 0);
        if(cache.containsKey(num))
            return cache.get(num);

        int gain = points.getOrDefault(num, 0);
        cache.put(num, Math.max(maxPoints(num - 1), maxPoints(num - 2) + gain));
        return cache.get(num);
    }
}
