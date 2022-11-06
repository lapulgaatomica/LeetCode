package queue;

import java.util.ArrayList;
import java.util.List;

public class MyQueue {
    private List<Integer> data;
    private int pStart;

    public MyQueue(){
        data = new ArrayList<>();
        pStart = 0;
    }

    public boolean enQueue(int x){
        data.add(x);
        return true;
    }

    public boolean deQueue(){
        if(isEmpty())
            return false;
        pStart++;
        return true;
    }

    public int front(){
        return data.get(pStart);
    }

    public boolean isEmpty(){
        return pStart >= data.size();
    }
}


