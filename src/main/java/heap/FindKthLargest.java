package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindKthLargest {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int num : nums)
            heap.offer(num);
        for(int i = 0; i < k - 1; i++){
            heap.poll();
        }
        return heap.peek();
    }
}
