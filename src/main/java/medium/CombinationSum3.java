package medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum3 {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7));
        System.out.println(combinationSum3(3, 9));
        System.out.println(combinationSum3(4, 1));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> answer = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();
        backtrack(0, k, n, list, answer);
        return answer;
    }

    private static void backtrack(int index, int sizeOfList, int target, LinkedList<Integer> list, List<List<Integer>> answer) {
        if(target == 0 && list.size() == sizeOfList){
            answer.add(new LinkedList<>(list));
            return;
        }

        if(target < 0 )
            return;
        for(int i = index; i <= target; i++){
            list.add(i + 1);
            backtrack(i + 1, sizeOfList, target - i - 1, list, answer);
            list.removeLast();
        }
    }
}
