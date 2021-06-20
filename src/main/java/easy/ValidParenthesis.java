package easy;

import java.util.*;

public class ValidParenthesis {
    public static void main(String[] args) {
//        System.out.println(isValid("{[{}]}"));//true
//        System.out.println(isValid("(){}}{"));//false
//        System.out.println(isValid("()"));//true
//        System.out.println(isValid("{[]}"));//true
//        System.out.println(isValid("(){}}{"));//false
//        System.out.println(isValid(")(){}"));//false
//        System.out.println(isValid("[({])}"));//false
        System.out.println(isValid("[({(())}[()])]"));//true
//        System.out.println(isValid("[()[[]()]]"));//true
//        System.out.println(isValid("([[][]{({}({}))}])"));//true
//        System.out.println(isValid("([[]][([][])({})]())"));//true

    }

    public static boolean isValid(String s) {
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            if (stack.isEmpty()){
                stack.push(s.charAt(i));
            }else{
                if(brackets.get(s.charAt(i)) == stack.peek()){
                    stack.pop();
                }else{
                    stack.push(s.charAt(i));
                }
            }
        }

        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}
