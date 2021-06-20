package easy;

import java.util.ArrayList;
import java.util.List;

public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[] {4,1,2,1,2}));
        System.out.println(singleNumber(new int[] {2, 2, 1}));
        System.out.println(singleNumber(new int[] {1}));
    }

    public static int singleNumber(int[] nums) {
        List<Integer> integers = new ArrayList<>();

        for (int num : nums) {
            if (!integers.isEmpty() && integers.contains(num)) {
                integers.remove(integers.indexOf(num));
            } else {
                integers.add(num);
            }
        }
        return integers.get(0);
    }
}
