package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GetFactors {
    public static void main(String[] args) {
        System.out.println(getFactors(1));
        System.out.println(getFactors(12));
        System.out.println(getFactors(100));
        System.out.println(getFactors(8192));
        System.out.println(getFactors2(1783377));
    }

    public static List<List<Integer>> getFactors(int n) {
        if(n == 1)
            return new ArrayList<>();
        List<List<Integer>> answer = new ArrayList<>();
        LinkedList<Integer> inner = new LinkedList<>();
        backtrack(2, 1, n, inner, answer);
        return answer;
    }

    private static void backtrack(int start, int multiplier, int n, LinkedList<Integer> inner, List<List<Integer>> answer) {
        if(multiplier == n){
            answer.add(new ArrayList<>(inner));
            return;
        }

        if(multiplier > n/2)
            return;

        for(int i = start; i <= n/2; i++){
            if(n % i != 0)
                continue;
            multiplier *= i;
            inner.add(i);
            backtrack(i, multiplier, n, inner, answer);
            multiplier /= i;
            inner.removeLast();
        }
    }

    public static List<List<Integer>> getFactors2(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(n, 2, new ArrayList<>(), ans);
        return ans;
    }

    private static void dfs(int n, int s, List<Integer> path, List<List<Integer>> ans) {
        if (n == 1) {
            if (path.size() > 1)
                ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = s; i <= n; ++i) {
            if (n % i == 0) {
                path.add(i);
                dfs(n / i, i, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }
}
