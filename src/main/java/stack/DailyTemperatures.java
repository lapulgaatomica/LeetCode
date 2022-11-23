package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30, 40, 50, 60})));
        System.out.println(Arrays.toString(dailyTemperatures1(new int[]{73,74,75,71,69,72,76,73})));
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        for(int i = 0; i < temperatures.length; i++){
            int temp = temperatures[i];
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && temp > stack.peek()) {
                    stack.pop();
                    int index = indexStack.pop();
                    answer[index] = i - index;
                }
            }
            stack.push(temp);
            indexStack.push(i);
        }
        return answer;
    }

    public static int[] dailyTemperatures1(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int currDay = 0; currDay < n; currDay++) {
            int currentTemp = temperatures[currDay];
            // Pop until the current day's temperature is not
            // warmer than the temperature at the top of the stack
            while (!stack.isEmpty() && temperatures[stack.peek()] < currentTemp) {
                int prevDay = stack.pop();
                answer[prevDay] = currDay - prevDay;
            }
            stack.push(currDay);
        }

        return answer;
    }
}
