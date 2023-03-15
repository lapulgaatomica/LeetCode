package recursion.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FindSubsequences {
    public static void main(String[] args) {
        System.out.println(findSubsequences(new int[]{4,6,7,7}));
        System.out.println(findSubsequences(new int[]{4,4,3,2,1}));
    }

    public static List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        helper(nums, 0, new LinkedList<>(), answer);
        return answer;
    }

    private static void helper(int[] nums, int index, LinkedList<Integer> inner, List<List<Integer>> answer) {
        if(index == 0){
            inner.add(nums[index]);
            helper(nums, index + 1, inner, answer);
        } else if (index >= nums.length) {
            answer.add(new ArrayList<>(inner));
        }else{
            for(int i = index; i < nums.length; i++){
                if(nums[i] < nums[i - 1])
                    return;
                inner.add(nums[i]);
                helper(nums, index + 1, inner, answer);
                inner.removeLast();
            }
        }
    }
}
