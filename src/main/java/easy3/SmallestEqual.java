package easy3;

public class SmallestEqual {
    public static void main(String[] args) {
        //https://leetcode.com/problems/smallest-index-with-equal-value/
        System.out.println(smallestEqual(new int[]{0, 1, 2}));
        System.out.println(smallestEqual(new int[]{4, 3, 2, 1}));
        System.out.println(smallestEqual(new int[]{1,2,3,4,5,6,7,8,9,0}));
    }

    public static int smallestEqual(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if(i % 10 == nums[i]){
                return i;
            }
        }
        return -1;
    }
}
