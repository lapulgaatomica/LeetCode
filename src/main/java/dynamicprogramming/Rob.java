package dynamicprogramming;

import java.util.HashMap;

public class Rob {
    private static HashMap<Integer, Integer> memo = new HashMap<>();
    private static int[] classNums;

    public static void main(String[] args) {
//        System.out.println(rob(new int[]{1,2,3,1}));
//        System.out.println(rob(new int[]{2,7,9,3,1}));
        System.out.println(rob2(new int[]{7,2,3,9,2,1}));
//        System.out.println(rob(new int[]{226,174,214,16,218,48,153,131,128,
//                17,157,142,88,43,37,157,43,221,191,68,206,
//                23,225,82,54,118,111,46,80,49,245,63,25,194,
//                72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,
//                225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,
//                193,211,84,239,119,234,85,83,123,120,131,
//                203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124}));
    }

    public static int rob(int[] nums) {
        //top down approach
        classNums = nums;
        return dp(nums.length - 1);
    }

    private static int dp(int i) {
        if(i == 0)
            return classNums[0];
        if(i == 1)
            return Math.max(classNums[0], classNums[1]);
        if(!memo.containsKey(i))
            memo.put(i, Math.max(dp(i - 1), dp(i - 2) + classNums[i]));
        return memo.get(i);
    }

    public static int rob2(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);

        return dp[nums.length - 1];
    }
}
