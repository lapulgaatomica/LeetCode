package easy3;

import java.util.*;
import java.util.stream.Collectors;

public class MissingNumbers {
    public static void main(String[] args) {
        System.out.println(missingNumbers(new ArrayList<>(Arrays.asList(7, 2, 5, 3, 5, 3)),
                new ArrayList<>(Arrays.asList(7, 2, 5, 4, 6, 3, 5, 3))));
        System.out.println(missingNumbers(new ArrayList<>(Arrays.asList(203, 204, 205, 206, 207, 208, 203, 204, 205, 206)),
                new ArrayList<>(Arrays.asList(203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204))));
        System.out.println(missingNumbers(new ArrayList<>(Arrays.asList(11, 4, 11, 7, 13, 4, 12, 11, 10, 14)),
                new ArrayList<>(Arrays.asList(11, 4, 11, 7, 3, 7, 10, 13, 4, 8, 12, 11, 10, 14, 12))));
    }

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        Map<Integer, Integer> frequency = new TreeMap<>();

        for(int br : brr){
            frequency.put(br, frequency.getOrDefault(br, 0) + 1);
        }

        for(int ar : arr){
            int freq = frequency.get(ar);
            if(freq == 1) {
                frequency.remove(ar);
            } else {
                frequency.put(ar, freq -1);
            }
        }

        return new ArrayList<>(frequency.keySet());
    }
}
