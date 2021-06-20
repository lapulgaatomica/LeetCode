package easy;

public class ClimbingStairs {
    public static void main(String[] args) {
//        System.out.println(climbStairs(2));
//        System.out.println(climbStairs(3));
//        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
    }

    public static int climbStairs(int n) {
        return climbStairs(0, n);
    }

    public static int climbStairs(int i, int n){
        if(i > n){
            return 0;
        }
        if(i == n){
            return 1;
        }
        System.out.println(i);
        return climbStairs(i + 1, n) + climbStairs(i + 2, n);
    }
}
