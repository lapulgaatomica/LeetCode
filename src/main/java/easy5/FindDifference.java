package easy5;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDifference {
    public static void main(String[] args) {
        System.out.println(findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6}));
        System.out.println(findDifference(new int[]{1,2,3,3}, new int[]{1,1,2,2}));
    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for(int num1 : nums1) {
            set1.add(num1);
        }

        Set<Integer> removedFromSet1 = new HashSet<>();
        for(int num2 : nums2) {
            if(set1.contains(num2) || removedFromSet1.contains(num2)){
                removedFromSet1.add(num2);
                set1.remove(num2);
            } else
                set2.add(num2);
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(set1));
        ans.add(new ArrayList<>(set2));
        return ans;
    }
}
