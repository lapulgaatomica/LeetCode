package greedy;

import java.util.*;
import java.util.stream.Collectors;

public class FindLeastNumOfUniqueInts {
    public static void main(String[] args) {
        System.out.println(findLeastNumOfUniqueInts(new int[]{5, 5, 4}, 1));
        System.out.println(findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,2}, 3));
    }

    public static int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int ar:arr){
            map.put(ar, map.getOrDefault(ar, 0) + 1);
        }

        List<Integer> sortedElements = new ArrayList<>();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> {
                    for(int i = 1; i <= entry.getValue(); i++)
                        sortedElements.add(entry.getKey());
                });
        while (k > 0 && !sortedElements.isEmpty()){
            sortedElements.remove(0);
            k--;
        }

        return new HashSet<>(sortedElements).size();
    }
}
