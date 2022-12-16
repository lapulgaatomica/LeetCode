package greedy;

import java.util.Arrays;

public class ArrayPairSum {
    public static void main(String[] args) {

    }

    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0; i < nums.length; i+=2){
            ans += nums[i];
        }
        return ans;
    }
}
