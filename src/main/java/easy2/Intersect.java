package easy2;

import java.util.*;

public class Intersect {
    public static void main(String[] args) {
        //https://leetcode.com/problems/intersection-of-two-arrays-ii/
        System.out.println(Arrays.toString(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> first = new HashMap<>();
        Map<Integer, Integer> second = new HashMap<>();

        for(int num1: nums1){
            first.put(num1, first.getOrDefault(num1, 0) + 1);
        }
        for(int num2: nums2){
            second.put(num2, second.getOrDefault(num2, 0) + 1);
        }

        Map<Integer, Integer> resultMap = new HashMap<>();
        int numberOfItems = 0;

        for(int key: first.keySet()){
            if(second.containsKey(key)){
                if(first.get(key) <= second.get(key)){
                    resultMap.put(key, first.get(key));
                    numberOfItems += first.get(key);
                }else{
                    resultMap.put(key, second.get(key));
                    numberOfItems += second.get(key);
                }
            }
        }

        int[] result = new int[numberOfItems];
        int j = 0;

        for(int key:resultMap.keySet()){
            for(int i = 0; i < resultMap.get(key); i++){
                result[j++] = key;
            }
        }
        return result;
    }
}
