package easy5;

import java.util.*;

public class FrequencySort {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(frequencySort(new int[]{1,1,2,2,2,3})));
        System.out.println(Arrays.toString(frequencySort(new int[]{-1,1,-6,4,5,-6,1,4,1})));
    }

    public static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(Map.Entry.<Integer, Integer>comparingByValue()
                .thenComparing(Map.Entry.comparingByValue())
                .thenComparing((Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) -> entry2.getKey().compareTo(entry1.getKey())));

        for(Map.Entry<Integer, Integer> entrySet : map.entrySet()) {
            heap.add(entrySet);
        }
        int index = 0;
        while (!heap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = heap.poll();
            int key = entry.getKey();
            int value = entry.getValue();
            while (value > 0) {
                nums[index++] = key;
                value--;
            }
        }
        return nums;
    }
}
