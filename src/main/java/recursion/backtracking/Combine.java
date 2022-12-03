package recursion.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combine {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(1, n, k, new LinkedList<>(), answer);
        return answer;
    }

    private static void backtrack(int first, int n, int k, LinkedList<Integer> current, List<List<Integer>> answer) {
        if(current.size() == k)
            answer.add(new LinkedList<>(current));

        for(int i = first; i <= n; i++){
            current.add(i);
            backtrack(i + 1, n, k, current, answer);
            current.removeLast();
        }
    }
}
