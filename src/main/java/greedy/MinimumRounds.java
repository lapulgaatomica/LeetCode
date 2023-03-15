package greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumRounds {
    public static void main(String[] args) {
        System.out.println(minimumRounds(new int[]{2,2,3,3,2,4,4,4,4,4}));
    }

    public static int minimumRounds(int[] tasks) {
        
        Map<Integer, Integer> map = new HashMap<>();
        for(int task : tasks)
            map.put(task, map.getOrDefault(task, 0) + 1);
        int timeTaken = 0;

        for(int value : map.values()){
            if(value == 1)
                return -1;
            if(value < 3)
                timeTaken += 1;
            else{
                timeTaken += (value / 3);
                value %= 3;
                if(value == 1){
                    timeTaken -= 1;
                    value += 3;
                }
                timeTaken += (value / 2);
            }
        }
        return timeTaken;
    }
}
