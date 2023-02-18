package medium;

import java.util.Arrays;

public class SortTransformedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortTransformedArray(new int[]{-4,-2,2,4}, 1, 3, 5)));
        System.out.println(Arrays.toString(sortTransformedArray(new int[]{-4, -2, 2, 4}, -1, 3, 5)));
    }

    public static int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        for(int i = 0; i < nums.length; i++){
            int curr = nums[i];
            nums[i] = (a * curr * curr) + (b * curr) + c;
        }
        Arrays.sort(nums);
        return nums;
    }
}
