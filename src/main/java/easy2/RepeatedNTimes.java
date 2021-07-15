package easy2;

import java.util.HashMap;
import java.util.Map;

public class RepeatedNTimes {
    public static void main(String[] args) {
        System.out.println(repeatedNTimes(new int[]{1,2,3,3}));
    }

    public static int repeatedNTimes(int[] nums) {
        // https://leetcode.com/problems/n-repeated-element-in-size-2n-array
        int n = nums.length / 2;
        Map<Integer, Integer> frequencyOfNs = new HashMap<>();

        for(int num : nums){
            frequencyOfNs.put(num, frequencyOfNs.getOrDefault(num, 0) + 1);
        }

        for(int key: frequencyOfNs.keySet()){
            if(frequencyOfNs.get(key) == n){
                return key;
            }
        }
        return -1;
    }
}
