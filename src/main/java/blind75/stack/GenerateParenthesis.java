package blind75.stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {
    //https://leetcode.com/problems/generate-parentheses/
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    static Stack<Character> stack = new Stack<>();
    static List<String> res = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        backtrack(0, 0, n);
        return res;
    }

    private static void backtrack(int openN, int closedN, int n) {
        if (openN == closedN && closedN == n) {
            Iterator<Character> vale = stack.iterator();
            StringBuilder temp = new StringBuilder();
            while (vale.hasNext()) {
                temp.append(vale.next());
            }
            res.add(temp.toString());
        }
        if (openN < n) {
            stack.push('(');
            backtrack(openN + 1, closedN, n);
            stack.pop();
        }
        if (closedN < openN) {
            stack.push(')');
            backtrack(openN, closedN + 1, n);
            stack.pop();
        }
    }
}
