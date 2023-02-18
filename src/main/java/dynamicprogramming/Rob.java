package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Rob {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
        System.out.println(rob(new int[]{2,7,9,3,1}));
        System.out.println(rob(new int[]{7,2,3,9,2,1}));
        System.out.println(rob(new int[]{226,174,214,16,218,48,153,131,128,17,157,142,88,43,37,157,43,221,191,68,206,
                23,225,82,54,118,111,46,80,49,245,63,25,194,72,80,143,55,209,18,55,122,65,66,177,101,63,201,172,130,103,
                225,142,46,86,185,62,138,212,192,125,77,223,188,99,228,90,25,193,211,84,239,119,234,85,83,123,120,131,
                203,219,10,82,35,120,180,249,106,37,169,225,54,103,55,166,124}));
    }

    static Map<Integer, Integer> map;
    public static int rob(int[] nums) {
        map = new HashMap<>();
        return dp(0, nums, 0);
    }

    private static int dp(int i, int[] nums, int ans) {
        if(map.containsKey(i))
            return map.get(i);
        if(i >= nums.length)
            return ans;
        int res = Math.max(dp(i + 1, nums, ans), dp(i + 2, nums, ans) + nums[i]);
        map.put(i, res);
        return map.get(i);
    }

    public static int robTLE(int[] nums) {
        return Math.max(dpTLE(0, nums, 0), dpTLE(1, nums, 0));
    }

    private static int dpTLE(int i, int[] nums, int ans) {
        if(i >= nums.length)
            return ans;
        return Math.max(dpTLE(i + 2, nums, ans + nums[i]), dpTLE(i + 3, nums, ans + nums[i]));
    }
}
