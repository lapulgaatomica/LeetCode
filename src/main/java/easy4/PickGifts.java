package easy4;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PickGifts {
    public static void main(String[] args) {
        System.out.println(pickGifts(new int[]{25, 64, 9, 4, 100}, 4));
        System.out.println(pickGifts(new int[]{1, 1, 1, 1}, 4));
    }

    public static long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for(int gift : gifts)
            priorityQueue.add(gift);
        for(int i = 0; i < k; i++){
            priorityQueue.add((int)Math.floor(Math.sqrt(priorityQueue.poll())));
        }
        long answer = 0;
        while (!priorityQueue.isEmpty())
            answer += priorityQueue.poll();;
        return answer;
    }
}
