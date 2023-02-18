package easy;

import java.util.Arrays;

public class SortedSquares {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares2(new int[]{-4,-1,0,3,10})));
        System.out.println(Arrays.toString(sortedSquares2(new int[]{-7,-3,2,3,11})));
        System.out.println(Arrays.toString(sortedSquares2(new int[]{-5,-3,-2,-1})));
    }

    public static int[] sortedSquares(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }

    public static int[] sortedSquares2(int[] nums) {
        int length = nums.length;
        int start = 0;
        int end = nums.length - 1;
        int[] result = new int[length];
        for(int i = length - 1; i >= 0; i--){
            if (Math.abs(nums[start]) < Math.abs(nums[end])) {
                result[i] = nums[end] * nums[end];
                end--;
            } else {
                result[i] = nums[start] * nums[start];
                start++;
            }
        }
        return result;
    }
}
