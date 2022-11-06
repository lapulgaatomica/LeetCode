package queue;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage {
    int size;
    Queue<Integer> queue;
    public MovingAverage(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        if(queue.size() == size)
            queue.poll();
        queue.offer(val);
        double sum = 0;
        for(int q : queue)
            sum += q;
        return sum / queue.size();
    }
}
