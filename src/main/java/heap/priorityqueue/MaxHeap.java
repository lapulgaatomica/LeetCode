package heap.priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(1);
        maxHeap.add(3);
        maxHeap.add(2);
        System.out.println("maxHeap: " + maxHeap);

        int peekNum = maxHeap.peek();
        System.out.println("peek number: " + peekNum);

        int pollNum = maxHeap.poll();
        System.out.println("poll number: " + pollNum);

        System.out.println("peek number: " + maxHeap.peek());

        System.out.println("maxHeap: " + maxHeap);

        int heapSize = maxHeap.size();

        System.out.println("maxHeap size: " + heapSize);

        boolean isEmpty = maxHeap.isEmpty();
        System.out.println("isEmpty: " + isEmpty);
    }
}
