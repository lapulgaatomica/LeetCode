package blind75.arraysandhashing;

import java.util.*;

public class FindKthLargest {
    public static void main(String[] args) {
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }

    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for(int num : nums){
            queue.offer(num);
            while (queue.size() > k){
                queue.poll();
            }
        }
        return queue.peek();
    }
}
