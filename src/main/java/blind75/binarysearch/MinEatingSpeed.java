package blind75.binarysearch;

public class MinEatingSpeed {
    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{3,6,7,11}, 8));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right){
            int mid = (right + left) / 2;
            int hoursTaken = 0;

            for(int pile : piles){
                hoursTaken += Math.ceil((double) pile / mid);
            }

            if(hoursTaken <= h){
                right = mid;
            } else  {
                left = mid + 1;
            }
        }
        return right;
    }
}
