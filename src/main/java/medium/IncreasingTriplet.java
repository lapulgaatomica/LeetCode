package medium;


public class IncreasingTriplet {
    public static void main(String[] args) {
        System.out.println(increasingTriplet(new int[]{1,2,3,4,5}) == true);
        System.out.println(increasingTriplet(new int[]{5,4,3,2,1}) == false);
        System.out.println(increasingTriplet(new int[]{2,1,5,0,4,6}) == true);
        System.out.println(increasingTriplet(new int[]{20,100,10,12,5,13}) == true);
        System.out.println(increasingTriplet(new int[]{0,4,2,1,0,-1,-3}) == false);
        System.out.println(increasingTriplet(new int[]{1,6,2,5,1}) == true);
        System.out.println(increasingTriplet(new int[]{20,100,10,12,5,4,13}) == true);
    }

    public static boolean increasingTriplet(int[] nums) {
        int firstNumber = Integer.MAX_VALUE;
        int secondNumber = Integer.MAX_VALUE;

        for(int n : nums){
            if(n <= firstNumber){
                firstNumber = n;
            }else if(n <= secondNumber){
                secondNumber = n;
            }else{
                return true;
            }
        }
        return false;
    }
}
