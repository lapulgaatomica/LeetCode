package greedy;

public class MinOperations {
    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{1,1,1}));
        System.out.println(minOperations(new int[]{1,5,2,4,1}));
        System.out.println(minOperations(new int[]{8}));
    }

    public static int minOperations(int[] nums) {
        int ans = 0;
        int previous = 0;
        for(int num : nums){
            if(num <= previous){
                ans += (previous + 1) - num;
                previous = previous + 1;
            }else{
                previous = num;
            }
        }
        return ans;
    }
}
