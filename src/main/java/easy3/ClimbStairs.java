package easy3;

public class ClimbStairs {
    public static void main(String[] args) {
//        System.out.println(climbStairs(2));
//        System.out.println(climbStairs(3));
//        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
    }

    public static int climbStairs(int n) {
        if(n == 0)
            return 0;

        if(n == 1)
            return 1;

        if(n == 2)
            return 2;

        return climbStairs(n -1) + climbStairs(n - 2);
    }
}
