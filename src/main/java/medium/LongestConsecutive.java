package medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutive {
    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
        System.out.println(longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
            set.add(num);

        int longestStreak = 0;

       for(int num : set){
           if(!set.contains(num - 1)){
               int currentNumber = num;
               int currentStreak = 1;

               while(set.contains(currentNumber + 1)){
                   currentNumber += 1;
                   currentStreak += 1;
               }

               longestStreak = Math.max(currentStreak, longestStreak);
           }
       }
       return longestStreak;
    }
}
