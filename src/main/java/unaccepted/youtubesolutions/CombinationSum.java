package unaccepted.youtubesolutions;

import java.util.*;

public class CombinationSum {
    public static void main(String[] args) {
        //https://leetcode.com/problems/combination-sum/
        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
//        System.out.println(combinationSum(new int[]{2,3,5}, 8));
//        System.out.println(combinationSum(new int[]{2}, 1));
//        System.out.println(combinationSum(new int[]{1}, 2));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        dfs(0, current, 0, target, answer, candidates);
        return answer;
    }

    public static void dfs(int i, List<Integer> current, int total, int target, List<List<Integer>> answer, int[] candidates){
        if(total == target){
            answer.add(List.copyOf(current));
            return;
        }
        if(i >= candidates.length || total > target){
            return;
        }
        current.add(candidates[i]);
        dfs(i, current, total + candidates[i], target, answer, candidates);
        current.remove(current.size() - 1);
        dfs(i + 1, current, total, target, answer, candidates);
    }
}
