package easy1;

import java.util.Arrays;

public class SmallerNumbersThanCurrent {
    public static void main(String[] args) {
        // https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{7, 7, 7, 7})));
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] answer = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            int currentNumber = nums[i];
            int numbersSmallerThanCurrent = 0;
            for(int num: nums){
                if(num < currentNumber){
                    numbersSmallerThanCurrent++;
                }
            }
            answer[i] = numbersSmallerThanCurrent;
        }
        return answer;
    }
}
