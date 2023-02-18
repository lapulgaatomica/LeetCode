package heap;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(Map.Entry.comparingByValue());

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            heap.add(entry);
            if(heap.size() > k)
                heap.poll();
        }

        int[] answer = new int[k];
        for(int i = 0; i < k; i++){
            answer[i] = heap.poll().getKey();
        }
        return answer;
    }
}
