package easy2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MigratoryBirds {
    public static void main(String[] args) {
        //https://www.hackerrank.com/challenges/migratory-birds/problem
        System.out.println(migratoryBirds(List.of(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4)));
    }

    public static int migratoryBirds(List<Integer> arr) {
        Map<Integer, Integer> frequencies = new TreeMap<>();

        for(int ar: arr){
            frequencies.put(ar, frequencies.getOrDefault(ar, 0) + 1);
        }
        int highestFrequency = 0;
        int numberWithHighestFrequency = -1;

        for(int key: frequencies.keySet()){
            if(frequencies.get(key) > highestFrequency){
                numberWithHighestFrequency = key;
                highestFrequency = frequencies.get(key);
            }
        }
        return numberWithHighestFrequency;
    }
}
