package easy1;

import java.util.Arrays;

public class RunningSum {
    public static void main(String[] args) {
        //https://leetcode.com/problems/running-sum-of-1d-array/
        System.out.println(Arrays.toString(runningSum(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(runningSum(new int[]{3,1,2,10,1})));
    }

    public static int[] runningSum(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(i > 0){
                nums[i] += nums[i - 1];
            }
        }
        return nums;
    }
}
