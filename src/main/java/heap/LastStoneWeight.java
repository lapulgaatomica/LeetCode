package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone : stones)
            heap.offer(stone);

        while (heap.size() >= 2){
            int largest = heap.poll();
            int secondLargest = heap.poll();
            if(largest > secondLargest)
                heap.offer(largest - secondLargest);
        }
        if(!heap.isEmpty())
            return heap.peek();
        return 0;
    }
}
