package queue;

public class MyQueueMain {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.enQueue(5);
        q.enQueue(3);
        if(!q.isEmpty())
            System.out.println(q.front());
        q.deQueue();
        if(!q.isEmpty())
            System.out.println(q.front());
    }
}
