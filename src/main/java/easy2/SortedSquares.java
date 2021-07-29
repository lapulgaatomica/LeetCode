package easy2;

import java.util.Arrays;

public class SortedSquares {
    public static void main(String[] args) {
        for(int num : sortedSquares(new int[]{-4,-1,0,3,10})){
            System.out.print(num + " ");
        }
    }

    public static int[] sortedSquares(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            nums[i] *= nums[i];
        }

        Arrays.sort(nums);

        return nums;
    }
}
