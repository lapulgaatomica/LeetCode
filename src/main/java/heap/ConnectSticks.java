package heap;

import java.util.PriorityQueue;

public class ConnectSticks {
    public static void main(String[] args) {
        System.out.println(connectSticks(new int[]{2, 4, 3}));
        System.out.println(connectSticks(new int[]{1, 8, 3, 5}));
        System.out.println(connectSticks(new int[]{5}));
    }

    public static int connectSticks(int[] sticks) {
        if(sticks.length < 2)
            return 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int stick : sticks)
            heap.offer(stick);

        int answer = 0;
        while (heap.size() > 1){
            int lowest = heap.poll();
            int secondLowest = heap.poll();
            answer += secondLowest + lowest;
            heap.offer(secondLowest + lowest);
        }

        return answer;
    }
}
