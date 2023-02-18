package heap.priorityqueue;

import java.util.PriorityQueue;

public class MinHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(3);
        minHeap.add(1);
        minHeap.add(2);
        System.out.println("minHeap: " + minHeap);

        int peekNum = minHeap.peek();
        System.out.println("peek number: " + peekNum);

        int pollNum = minHeap.poll();
        System.out.println("poll number: " + pollNum);

        System.out.println("peek number: " + minHeap.peek());

        System.out.println("minHeap: " + minHeap);

        int heapSize = minHeap.size();
        System.out.println("minHeap size: " + heapSize);

        boolean isEmpty = minHeap.isEmpty();
        System.out.println("isEmpty: " + isEmpty);
    }
}
