package medium;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(productExceptSelf1(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(productExceptSelf1(new int[]{1,-1,0,-3,3})));
    }

    public static int[] productExceptSelf(int[] nums) {
        boolean containsZero = false;
        int product = 1;
        for(int num : nums){
            if (num == 0 && !containsZero)
                containsZero = true;
            else
                product *= num;
        }
        for(int i = 0; i < nums.length; i++){
            if(containsZero){
                if(nums[i] != 0)
                    nums[i] = 0;
                else
                    nums[i] = product;
            }else{
                nums[i] = product / nums[i];
            }
        }
        return nums;
    }

    public static int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);

        // Perform Prefix product operation by traversing Left -> Right
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        // Perform Postfix product operation by traversing Right -> Left
        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }
        return result;
    }
}
