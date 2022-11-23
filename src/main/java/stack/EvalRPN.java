package stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class EvalRPN {
    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"2","1","+","3","*"}));
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));
        System.out.println(evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }

    public static int evalRPN(String[] tokens) {
        Set<String> operators = new HashSet<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (operators.contains(token)) {
                int second = stack.pop();
                int first = stack.pop();

                switch (token) {
                    case "*" -> stack.push(first * second);
                    case "/" -> stack.push(first / second);
                    case "+" -> stack.push(first + second);
                    case "-" -> stack.push(first - second);
                }
            }else
                stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }
}
