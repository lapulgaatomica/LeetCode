package unaccepted;

public class LongestOnes {
    public static void main(String[] args) {
        //https://leetcode.com/problems/max-consecutive-ones-iii/
        System.out.println(longestOnes(new int[] {1,1,1,0,0,0,1,1,1,1,0},2));//6
        System.out.println(longestOnes(new int[] {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1},3));//10
        System.out.println(longestOnes(new int[] {0, 0, 0, 1},4));//10
    }

    public static int longestOnes(int[] nums, int k) {
        int highestNumberOfOnes = 0;
        for(int i = 0; i < nums.length; i++){
            int numberOfOnes = 0;
            int kLeft = k;
            for(int j = i; j < nums.length; j++){
                if(nums[j] == 1){
                    numberOfOnes++;
                    if(j == nums.length - 1){
                        highestNumberOfOnes = Math.max(numberOfOnes, highestNumberOfOnes);
                        numberOfOnes = 0;
                        kLeft = k;
                    }
                }else{
                    if(kLeft > 0){
                        numberOfOnes++;
                        kLeft--;
                    }else{
                        highestNumberOfOnes = Math.max(numberOfOnes, highestNumberOfOnes);
                        break;
                    }
                }
            }
        }
        return highestNumberOfOnes;
    }
}
