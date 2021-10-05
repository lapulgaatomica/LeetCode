package easy1;

import java.util.Arrays;

public class RemoveDuplicates {
    public static void main(String[] args) {
        //https://leetcode.com/problems/remove-duplicates-from-sorted-array/
        System.out.println(removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(removeDuplicates(new int[]{}));
        System.out.println(removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public static int removeDuplicates(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        int size = 0;
        for(int i = 0; i < copy.length; i++){
            if(i == 0){
                nums[size++] = copy[i];
            }else{
                if(copy[i] > copy[i - 1]){
                    nums[size++] = copy[i];
                }
            }
        }
        return size;
    }
}
