package recursion;

public class MyPow {
    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10));
        System.out.println(myPow(2.10000, 3));
        System.out.println(myPow(2.00000, -2));
        System.out.println(myPow(0.00001, 2147483647));
    }
    public static double myPow(double x, int n) {
        long N = n;
        if(N == 0)
            return 1;
        if(N < 0){
            N = -N;
            x = 1 / x;
        }
        return myPowHelper(x, N);
    }

    private static double myPowHelper(double x, long n) {
        if(n == 0)
            return 1;
        double res = myPowHelper(x, n / 2);
        if(n % 2 == 1)
            res = res * res * x;
        else
            res = res * res;
        return res;
    }
}
