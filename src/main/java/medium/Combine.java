package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combine {
    public static void main(String[] args) {
        System.out.println(combine(4, 2));
        System.out.println(combine(1, 1));
    }

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        LinkedList<Integer> inner = new LinkedList<>();
        backtrack(1, n, k, inner, answer);
        return answer;
    }

    private static void backtrack(int start, int n, int k, LinkedList<Integer> inner, List<List<Integer>> answer) {
        if(inner.size() == k){
            answer.add(new ArrayList<>(inner));
            return;
        }

        for(int i = start; i <= n; i++){
            inner.add(i);
            backtrack(i + 1, n, k, inner, answer);
            inner.removeLast();
        }
    }
}
