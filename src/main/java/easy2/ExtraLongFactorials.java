package easy2;

import java.math.BigInteger;

public class ExtraLongFactorials {
    public static void main(String[] args) {
        //https://www.hackerrank.com/challenges/extra-long-factorials/problem
        extraLongFactorials(25);
    }

    public static void extraLongFactorials(int n) {
        BigInteger bigInteger = new BigInteger("1");
        for(int i = n; i > 1; i--){
            bigInteger = bigInteger.multiply(new BigInteger(String.valueOf(i)));
        }

        System.out.println(bigInteger);
    }
}
