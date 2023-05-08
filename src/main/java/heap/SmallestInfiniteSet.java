package heap;

import java.util.PriorityQueue;

public class SmallestInfiniteSet {
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    public SmallestInfiniteSet() {
        for(int i = 1; i <= 1000; i++){
            heap.add(i);
        }
    }

    public int popSmallest() {
        int curr = heap.poll();
        while (!heap.isEmpty() && heap.peek() == curr)
            heap.poll();
        return curr;
    }

    public void addBack(int num) {
        heap.offer(num);
    }
}

class Main {
    public static void main(String[] args) {
        SmallestInfiniteSet set = new SmallestInfiniteSet();
        set.addBack(2);
        int smallest = set.popSmallest();
        System.out.println();
    }
}
