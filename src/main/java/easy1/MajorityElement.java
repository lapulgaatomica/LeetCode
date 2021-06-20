package easy1;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));
        System.out.println(majorityElement(new int[]{3, 2, 3}));
    }

    public static int majorityElement(int[] nums) {
        int half = nums.length / 2;
        Map<Integer, Integer> counts = new HashMap<>();

        for(int num: nums){
            if(counts.containsKey(num)){
                counts.put(num, counts.get(num) + 1);
            }else{
                counts.put(num, 1);
            }
        }

        for(int key: counts.keySet()){
            if(counts.get(key) > half){
                return key;
            }
        }
        return -1;
    }
}
