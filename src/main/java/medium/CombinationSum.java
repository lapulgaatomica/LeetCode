package medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(combinationSum(new int[]{2,3,5}, 8));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        helper(candidates, target, answer, 0, new ArrayList<>());

        return answer;
    }

    public static void helper(int[] candidates, int target, List<List<Integer>> answer, int curr, ArrayList<Integer> innerList){
        if(curr == target){
            int prev = Integer.MIN_VALUE;
            for(int num : innerList){
                if(num < prev)
                    return;
                prev = num;
            }
            answer.add(new ArrayList<>(innerList));
            return;
        }
        if(curr > target)
            return;


        for(int candidate : candidates){
            curr += candidate;
            innerList.add(candidate);
            helper(candidates, target, answer, curr, innerList);
            innerList.remove(innerList.size() - 1);
            curr -= candidate;
        }
    }

}
