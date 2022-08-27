package blind75.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class IsValid {
    //https://leetcode.com/problems/valid-parentheses/
    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        for(char ch : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek() == map.get(ch)){
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
