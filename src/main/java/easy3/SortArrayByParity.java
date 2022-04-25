package easy3;

import java.util.Arrays;
//https://leetcode.com/problems/sort-array-by-parity-ii/
public class SortArrayByParity {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(sortArrayByParityII(new int[]{2, 3, 5, 4, 7, 6})));
        System.out.println(Arrays.toString(sortArrayByParityIII(new int[]{648,831,560,986,192,424,997,829,897,843})));
    }

    public static int[] sortArrayByParityII(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(i % 2 != nums[i] % 2){
                for(int j = i + 1; j < nums.length; j++){
                    if(j % 2 != nums[j] % 2 && i % 2 != j % 2){
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    }
                }
            }
        }
        return nums;
    }

    public static int[] sortArrayByParityIII(int[] nums) {
        int evenIndex = 0;
        int oddIndex = 1;
        int lengthOfArray = nums.length;
        while (evenIndex < lengthOfArray && oddIndex < lengthOfArray){
            while (evenIndex < lengthOfArray && nums[evenIndex] % 2 == 0){
                evenIndex += 2;
            }
            while (oddIndex < lengthOfArray && nums[oddIndex] % 2 != 0){
                oddIndex += 2;
            }
            if(evenIndex < lengthOfArray && oddIndex < lengthOfArray ){
                int temp = nums[evenIndex];
                nums[evenIndex] = nums[oddIndex];
                nums[oddIndex] = temp;
            }
            evenIndex += 2;
            oddIndex += 2;
        }
        return nums;
    }
}
