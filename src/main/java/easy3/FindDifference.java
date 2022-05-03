package easy3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindDifference {
    public static void main(String[] args) {
        System.out.println(findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6}));
        System.out.println(findDifference(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2}));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> first = new HashSet<>();
        Set<Integer> firstList = new HashSet<>();
        Set<Integer> secondList = new HashSet<>();

        for(int num : nums1){
            first.add(num);
            firstList.add(num);
        }


        for (int num : nums2){
            if(!first.contains(num))
                secondList.add(num);
            else
                firstList.remove(num);
        }
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>(firstList));
        answer.add(new ArrayList<>(secondList));
        return answer;
    }
}
