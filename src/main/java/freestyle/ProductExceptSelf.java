package freestyle;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] newNums = new int[nums.length];
        Arrays.fill(newNums, 1);

        int prefix = 1;
        for(int i = 0; i < nums.length; i++){
            newNums[i] *= prefix;
            prefix *= nums[i];
        }

        int postFix = 1;
        for(int i = nums.length - 1; i >= 0; i-- ){
            newNums[i] *= postFix;
            postFix *= nums[i];
        }

        return newNums;
    }
}
