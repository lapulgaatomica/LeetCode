package easy4;

import java.util.HashMap;
import java.util.Map;

public class NumIdenticalPairs {
    public static void main(String[] args) {
        System.out.println(numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
        System.out.println(numIdenticalPairs(new int[]{1, 1, 1, 1}));
        System.out.println(numIdenticalPairs(new int[]{1, 2, 3}));
    }

    public static int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        int answer = 0;

        for(int value : map.values()){
            if(value > 1){
                answer += ((value * (value - 1)) / 2);
            }
        }
        return answer;
    }
}
