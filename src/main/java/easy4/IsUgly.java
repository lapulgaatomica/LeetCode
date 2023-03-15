package easy4;

import java.math.BigDecimal;

public class IsUgly {
    public static void main(String[] args) {
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
    }

    public static boolean isUgly(int n) {
        if(n <= 0)
            return true;

        for(int factor : new int[]{2, 3, 5}){
            n = keepDividingWhenDivisible(n, factor);
        }

        return n == 1;
    }

    private static int keepDividingWhenDivisible(int dividend, int divisor) {
        while (dividend % divisor == 0)
            dividend /= divisor;
        return dividend;
    }

//    public static int nthUglyNumber(int n) {
//
//    }
}
