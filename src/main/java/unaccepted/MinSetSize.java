package unaccepted;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MinSetSize {
    public static void main(String[] args) {
        https://leetcode.com/problems/reduce-array-size-to-the-half/
        System.out.println(minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7}));
        System.out.println(minSetSize(new int[]{7,7,7,7,7,7}));
        System.out.println(minSetSize(new int[]{1, 9}));
        System.out.println(minSetSize(new int[]{1000,1000, 3, 7}));
        System.out.println(minSetSize(new int[]{1,2,3,4,5,6,7,8,9,10}));
    }

    public static int minSetSize(int[] arr) {
        int halfOfLengthOfArray =  arr.length / 2;
        Map<Integer, Integer> frequencyOfNumbers = new HashMap<>();
        Map<Integer, Integer> numberOfFrequencies = new TreeMap<>(Collections.reverseOrder());

        // Get frequency of numbers
        for(int currentNumber : arr){
            frequencyOfNumbers.put(currentNumber, frequencyOfNumbers.getOrDefault(currentNumber, 0) + 1);
        }

        if(frequencyOfNumbers.keySet().size() == 1){
            return 1;
        }

        // Count how many times frequency occurs
        for(int currentKey: frequencyOfNumbers.keySet()){
            int frequencyOfCurrentKey = frequencyOfNumbers.get(currentKey);
            numberOfFrequencies.put(frequencyOfCurrentKey,
                    numberOfFrequencies.getOrDefault(frequencyOfCurrentKey, 0) + 1);
        }

        int sum = 0;
        int count = 0;

        if(numberOfFrequencies.keySet().size() == 1){
            return halfOfLengthOfArray;
        }

        for(int frequency: numberOfFrequencies.keySet()){
            count++;
            sum += frequency;

            if(sum >= halfOfLengthOfArray){
                return count;
            }
        }

        return count;
    }
}
