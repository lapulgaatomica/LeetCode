package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValid {
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(}"));
        System.out.println(isValid("(({}))"));
    }

    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            if(stack.isEmpty()){
                if(map.containsValue(ch))
                    stack.push(ch);
                else
                    return false;
            }else{
                if(stack.peek() == map.get(ch))
                    stack.pop();
                else{
                    if (map.containsValue(ch))
                        stack.push(ch);
                    else
                        return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
