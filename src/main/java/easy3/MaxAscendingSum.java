package easy3;

public class MaxAscendingSum {
    public static void main(String[] args) {
        System.out.println(maxAscendingSum(new int[]{10,20,30,5,10,50}));
        System.out.println(maxAscendingSum(new int[]{10,20,30,40,50}));
        System.out.println(maxAscendingSum(new int[]{12,17,15,13,10,11,12}));
        System.out.println(maxAscendingSum(new int[]{12}));
    }

    public static int maxAscendingSum(int[] nums) {
        int maxSum = 0;
        int currentSum = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                currentSum = nums[i];
                maxSum = nums[i];
            }else{
                if(nums[i] > nums[i - 1]){
                    currentSum += nums[i];
                    if(currentSum > maxSum)
                        maxSum = currentSum;
                }else{
                    if(currentSum > maxSum)
                        maxSum = currentSum;
                    currentSum = nums[i];
                }
            }
        }
        return maxSum;
    }
}
