package stack;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    private List<Integer> data;
    private List<Integer> minData;
    public MinStack() {
        data = new ArrayList<>();
        minData = new ArrayList<>();
    }

    public void push(int val) {
        data.add(val);
        if(minData.isEmpty())
            minData.add(val);
        else{
            if(val < minData.get(minData.size() - 1))
                minData.add(val);
            else
                minData.add(minData.get(minData.size() - 1));
        }
    }

    public void pop() {
        data.remove(data.size() - 1);
        minData.remove(minData.size() - 1);
    }

    public int top() {
        return data.get(data.size() - 1);
    }

    public int getMin() {
        return minData.get(minData.size() - 1);
    }
}

class Main{
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
