package sorting;

import java.util.Arrays;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int index = nums.length - 1;
        while (k > 1){
            k--;
            index--;
        }
        return nums[index];
    }
}
