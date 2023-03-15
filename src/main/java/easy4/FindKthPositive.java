package easy4;

public class FindKthPositive {
    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[]{2,3,4,7,11}, 5));
        System.out.println(findKthPositive(new int[]{1,2,3,4}, 2));
        System.out.println(findKthPositive(new int[]{2}, 1));
        System.out.println(findKthPositive(new int[]{3, 10}, 2));
    }

    public static int findKthPositive(int[] arr, int k) {
        int prev = 0;

        for(int ar : arr){
            int sub = ar - prev - 1;
            if(sub > 0){
                if(sub >= k){
                    return prev + k;
                } else {
                    k -= sub;
                }
            }
            prev = ar;
        }
        return prev + k;
    }
}
