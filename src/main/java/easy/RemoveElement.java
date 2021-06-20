package easy;

public class RemoveElement {

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{3,3, 2, 2, 3}, 3));
    }

    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0){
            return 0;
        }

        int i = 0;

        for(int j = 0; j < nums.length; j++){
            if(nums[j] != val){
                nums[i] = nums[j];
                i++;
            }
        }
        for(int k : nums){
            System.out.print(k);
        }
        return i;
    }
}

