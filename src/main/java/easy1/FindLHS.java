package easy1;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FindLHS {
    public static void main(String[] args) {
        // https://leetcode.com/problems/longest-harmonious-subsequence/
        System.out.println(findLHS(new int[]{1,3,2,2,5,2,3,7}));
        System.out.println(findLHS(new int[]{1, 2, 3, 4}));
        System.out.println(findLHS(new int[]{1, 1, 1, 1}));
    }

    public static int findLHS(int[] nums) {
        int lhs = 0;
        Map<Integer, Integer> map = new TreeMap<>();
        for(int num: nums){
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }


        int count = 0;
        int[] arrayOfKeySet = new int[map.keySet().size()];
        for(int i : map.keySet()){
            arrayOfKeySet[count] = i;
            count++;
        }
        int previousKey = arrayOfKeySet[0];

        count = 0;
        for(int key: arrayOfKeySet){
            if(count != 0 && key - previousKey == 1){
                int sumOfValues = map.get(previousKey) + map.get(key);
                if (sumOfValues > lhs){
                    lhs = sumOfValues;
                }
            }
            count++;
            previousKey = key;
        }

        return lhs;
    }
}
