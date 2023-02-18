package heap;

import java.util.PriorityQueue;

public class KthLargest {
    int k;
    PriorityQueue<Integer> heap;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new PriorityQueue<>();
        for(int num : nums){
            heap.offer(num);
            if(heap.size() > k)
                heap.poll();
        }
    }

    public int add(int val) {
        heap.offer(val);
        if(heap.size() > k)
            heap.poll();
        return heap.peek();
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));
        System.out.println(kthLargest.add(5));
        System.out.println(kthLargest.add(10));
        System.out.println(kthLargest.add(9));
        System.out.println(kthLargest.add(4));
    }
}
