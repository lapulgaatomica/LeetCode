package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {
    public static void main(String[] args) {
        System.out.println(frequencySort("Aabb"));
        System.out.println((int)'0');
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        PriorityQueue<Map.Entry<Character, Integer>> heap = new PriorityQueue<>(Map.Entry.<Character, Integer>comparingByValue().reversed());
        for(Map.Entry<Character, Integer> entry : map.entrySet())
            heap.add(entry);
        StringBuilder answer = new StringBuilder();
        while (!heap.isEmpty()){
            Map.Entry<Character, Integer> curr = heap.poll();
            int value = curr.getValue();
            char key = curr.getKey();
            for(int i = 0; i < value; i++)
                answer.append(key);
        }
        return answer.toString();
    }
}
