package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinSetSize {
    public static void main(String[] args) {
        System.out.println(minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7}));
    }

    public static int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int ar : arr){
            map.put(ar, map.getOrDefault(ar, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(Map.Entry.<Integer, Integer>comparingByValue().reversed());
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
            heap.offer(entry);

        int answer = 0;
        int freq = 0;
        while(freq < arr.length / 2){
            freq += heap.poll().getValue();
            answer++;
        }
        return answer;
    }
}
