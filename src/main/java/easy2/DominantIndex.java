package easy2;

public class DominantIndex {
    public static void main(String[] args) {
        // https://leetcode.com/problems/largest-number-at-least-twice-of-others/
        System.out.println(dominantIndex(new int[]{3, 6, 1, 0}) == 1);
        System.out.println(dominantIndex(new int[]{1, 2, 3, 4}) == -1);
        System.out.println(dominantIndex(new int[]{1}) == 0);
        System.out.println(dominantIndex(new int[]{0, 0, 3, 2}) == -1);
        System.out.println(dominantIndex(new int[]{0, 0, 1, 2}) == 3);
        System.out.println(dominantIndex(new int[]{3, 0, 0, 2}) == -1);
    }

    public static int dominantIndex(int[] nums) {
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;
        int indexOfHighest = 0;

        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                highest = nums[i];
            }else{
                if(nums[i] > highest){
                    secondHighest = highest;
                    highest = nums[i];
                    indexOfHighest = i;
                    continue;
                }
                if(nums[i] > secondHighest){
                    secondHighest = nums[i];
                }
            }
        }

        if(highest/2 >= secondHighest || highest == secondHighest){
            return indexOfHighest;
        }

        return -1;
    }
}
