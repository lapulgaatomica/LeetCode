package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum4 {
    public static void main(String[] args) {
        System.out.println(combinationSum4(new int[]{1, 2, 3}, 4));
        System.out.println(combinationSum4(new int[]{9}, 3));
        System.out.println(combinationSum4(new int[]{4, 2, 1}, 32));
    }

    public static int combinationSum4(int[] nums, int target) {
//        Arrays.sort(nums);
        List<List<Integer>> outer = new ArrayList<>();
        LinkedList<Integer> inner = new LinkedList<>();
        backtrack(0, nums, target, inner, outer);
        System.out.println(outer);
        return outer.size();
    }

    private static void backtrack(int start, int[] nums, int target, LinkedList<Integer> inner, List<List<Integer>> outer) {
        if(target < 0)
            return;
        if(target == 0){
            outer.add(new ArrayList<>(inner));
            return;
        }


//        for(int i = start; i < nums.length; i++){
////            target -= nums[i];
//            inner.addLast(nums[i]);
//            backtrack(i, nums, target - nums[i], inner, outer);
////            target += nums[i];
//            inner.removeLast();
//        }

        for(int i = nums.length - 1;  i >= 0; i--){
//            target -= nums[i];
            inner.addFirst(nums[i]);
            backtrack(i, nums, target - nums[i], inner, outer);
//            target += nums[i];
            inner.removeFirst();
        }
    }
}
