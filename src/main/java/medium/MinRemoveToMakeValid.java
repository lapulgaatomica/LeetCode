package medium;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MinRemoveToMakeValid {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)("));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid("))(("));
        System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
    }

    public static String minRemoveToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        LinkedList<Integer> open = new LinkedList<>();
        LinkedList<Integer> close = new LinkedList<>();

        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if(curr == '('){
                stack.push(curr);
                open.add(i);
            }else if(curr == ')'){
                if(!stack.empty()){
                    stack.pop();
                    close.add(i);
                }
            }
        }
        while (!stack.isEmpty()){
            char pop = stack.pop();
            if(pop == '(')
                open.removeLast();
            else
                close.removeLast();
        }
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            if((curr == ')' || curr == '(')){
                if(!open.isEmpty() && !close.isEmpty()){
                    if(open.peek() < close.peek() && open.peek() == i){
                        answer.append(curr);
                        open.removeFirst();
                    } else if (close.peek() < open.peek() && close.peek() == i) {
                        answer.append(curr);
                        close.removeFirst();
                    }
                } else if (!close.isEmpty()) {
                    if(close.peek() == i){
                        answer.append(curr);
                        close.removeFirst();
                    }
                }
            }else{
                answer.append(curr);
            }
        }

        return answer.toString();
    }
}
