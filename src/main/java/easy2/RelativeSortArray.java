package easy2;

import java.util.*;
import java.util.stream.Collectors;

public class RelativeSortArray {
    public static void main(String[] args) {
        // https://leetcode.com/problems/relative-sort-array/
        for(int i : relativeSortArray(new int[]{2,3,1,3,2,4,6,7,9,2,19}, new int[]{2,1,4,3,9,6})){
            System.out.print(i + " ");
        }
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] answer = new int[arr1.length];
        Map<Integer, Integer> mapOfFrequencies = new HashMap<>();

        for(int ar1: arr1){
            mapOfFrequencies.put(ar1, mapOfFrequencies.getOrDefault(ar1, 0) + 1);
        }

        int pointer = 0;

        for(int ar2: arr2){
            int frequencyOfAr2 = mapOfFrequencies.get(ar2);
            for(int i = pointer; i < pointer + frequencyOfAr2; i++){
                answer[i] = ar2;
            }
            pointer += frequencyOfAr2;
            mapOfFrequencies.remove(ar2);
        }

        Set<Integer> set = new TreeSet<>(mapOfFrequencies.keySet());

        for(int remaining: set){
            int frequencyOfRemaining = mapOfFrequencies.get(remaining);
            for(int i = pointer; i < pointer + frequencyOfRemaining; i++){
                answer[i] = remaining;
            }
            pointer += frequencyOfRemaining;
        }

        return answer;
    }
}
