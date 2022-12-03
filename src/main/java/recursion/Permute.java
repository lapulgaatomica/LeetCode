package recursion;

import java.util.*;
import java.util.stream.Collectors;

public class Permute {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        List<List<Integer>> permute = permute2(ints);
        System.out.println(permute);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        recurse(nums, new LinkedList<>(), answer);
        return answer;
    }

    private static void recurse(int[] nums, LinkedList<Integer> innerList, List<List<Integer>> answer) {
        if(nums.length == 0)
            answer.add(new LinkedList<>(innerList));

        for(int i = 0; i < nums.length; i++){
            int[] newArray = new int[nums.length - 1];
            int counter = 0;
            for(int j = 0; j < nums.length; j++){
                if(j != i)
                    newArray[counter++] = nums[j];
            }
            LinkedList<Integer> newInnerList = new LinkedList<>(innerList);
            newInnerList.add(nums[i]);
            recurse(newArray, newInnerList, answer);
        }
    }

    public static List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        helper(0, nums, answer);
        return answer;
    }

    private static void helper(int i, int[] nums, List<List<Integer>> answer) {
        if(i == nums.length - 1){
            List<Integer> list = new LinkedList<>();
            for(int num : nums)
                list.add(num);
            answer.add(new LinkedList<>(list));
        }
        for(int j = i; j < nums.length; j++){
            swap(i, j, nums);
            helper(i + 1, nums, answer);
            swap(i, j, nums);
        }
    }

    private static void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
