package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
        System.out.println(combinationSum2(new int[]{2,5,2,1,2}, 5));
        System.out.println(combinationSum2(new int[]{1, 2}, 4));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(candidates, target, 0, new LinkedList<>(), answer);
        return answer;
    }

    private static void backtrack(int[] candidates, int target, int curr, LinkedList<Integer> innerList, List<List<Integer>> answer) {
        if(target == 0){
            answer.add(new ArrayList<>(innerList));
            return;
        }
        if(target < 0)
            return;

        int prev = -1;
        for(int i = curr; i < candidates.length; i++){
            if(candidates[i] == prev)
                continue;
            innerList.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, innerList, answer);
            innerList.removeLast();
            prev = candidates[i];
        }
    }
}
