package dynamicprogramming;

import java.util.Arrays;

public class Rob2 {
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 1, 1, 2}) == 3);
        System.out.println(rob(new int[]{2, 3, 2}) == 3);
        System.out.println(rob(new int[]{1, 2, 3, 1}) == 4);
        System.out.println(rob(new int[]{1, 2, 3}) == 3);
        System.out.println(rob(new int[]{200, 3, 140, 20, 10}) == 340);
        System.out.println(rob(new int[]{2, 1, 1, 1}) == 3);
        System.out.println(rob(new int[]{1,2,3,4,5,1,2,3,4,5}) );
    }

    public static int rob(int[] nums) {
        int length = nums.length;
        if(length == 0)
            return 0;
        if(length == 1)
            return nums[0];
        int[] first = Arrays.copyOfRange(nums, 0, length -1);
        int[] second = Arrays.copyOfRange(nums, 1, length);
        return Math.max(rob2(first), rob2(second));
    }

    public static int rob2(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < nums.length; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);

        return dp[nums.length - 1];
    }
}
