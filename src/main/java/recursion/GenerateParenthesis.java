package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n){
        List<String> answer = new ArrayList<>();
        backtrack(0, 0, n, new StringBuilder(), answer);
        return answer;
    }

    private static void backtrack(int open, int close, int n, StringBuilder string, List<String> answer) {
        if(string.length() == n * 2){
            answer.add(string.toString());
            return;
        }

        if(open < n){
            string.append('(');
            backtrack(open + 1, close, n, string, answer);
            string.deleteCharAt(string.length() - 1);
        }

        if(close < open){
            string.append(')');
            backtrack(open, close + 1, n, string, answer);
            string.deleteCharAt(string.length() - 1);
        }
    }
}
