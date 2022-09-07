package freestyle;

import java.util.*;

public class TopKFrequent {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            priorityQueue.offer(entry);
            if(priorityQueue.size() > k){
                priorityQueue.poll();
            }
        }

        int[] answer = new int[k];
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : priorityQueue){
            answer[count] = entry.getKey();
            count++;
        }
        return answer;
    }
}
