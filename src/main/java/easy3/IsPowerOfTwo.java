package easy3;

public class IsPowerOfTwo {
    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo(3));
    }

    public static boolean isPowerOfTwo(int n) {
        if(n == 1){
            return true;
        }else if(n % 2 != 0){
            return false;
        }else{
            int multiple = 1;
            while (multiple <= n){
                multiple *= 2;
                if(multiple == n){
                    return true;
                }
            }
        }
        return false;
    }
}
