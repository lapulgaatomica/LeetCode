package queue;

public class MyCircularQueue {
    private int head;
    private int tail;
    private final int[] queue;
    private boolean isEmpty;
    private int size;
    public MyCircularQueue(int k) {
        queue = new int[k];
        head = -1;
        tail = -1;
        size = 0;
        isEmpty = true;
    }

    public boolean enQueue(int value) {
        if(isFull())
            return false;
        tail = (tail + 1) % (queue.length);
        queue[tail] = value;
        size++;
        if(head == -1)
            head = tail;
        isEmpty = false;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty)
            return false;
        head = (head + 1) % (queue.length);
        size--;
        if(size == 0)
            isEmpty = true;
        return true;
    }

    public int Front() {
        if(isEmpty)
            return -1;
        return queue[head];
    }

    public int Rear() {
        if(isEmpty)
            return -1;
        return queue[tail];
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public boolean isFull() {
        return size == queue.length;
    }
}
