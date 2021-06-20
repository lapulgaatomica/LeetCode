package easy;

public class Sqrtx {
    public static void main(String[] args) {
//        System.out.println(mySqrt(10));
//        System.out.println(mySqrt(36));
//        System.out.println(mySqrt(4));
//        System.out.println(mySqrt(2147483647));
    }

    public static int mySqrt(int x) {

        if(x == 0){
            return 0;
        }

        int start = 1;
        int end = x;
        int ans = 1;

        while(start <= end){
            int mid = (start + end) / 2;

            System.out.println(start + " " + mid + " " + end);

            if(mid <= x / mid){ // can be re-written as mid * mid <= x in theory but will cause overflow in practice
                ans = mid;
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return ans;
    }
}
