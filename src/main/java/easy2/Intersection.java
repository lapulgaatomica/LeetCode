package easy2;

import java.util.*;

public class Intersection {
    public static void main(String[] args) {
        // https://leetcode.com/problems/intersection-of-two-arrays/
        System.out.println(Arrays.toString(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> first = new HashSet<>();
        Set<Integer> second = new HashSet<>();
        
        for(int num1: nums1){
            first.add(num1);
        }

        for(int num2: nums2){
            if(first.contains(num2)){
                second.add(num2);
            }
        }

        int[] result = new int[second.size()];
        int j = 0;

        for(int number: second){
            result[j++] = number;
        }
        return result;
    }
}
