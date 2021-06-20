package easy1;

import java.math.BigInteger;

public class FactorialTrailingZeroes {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(5));
        System.out.println(trailingZeroes(3));
        System.out.println(trailingZeroes(1));
        System.out.println(trailingZeroes(10));
    }

    public static int trailingZeroes(int n) {
        /**
        Attached the code below in case you just want that, and none of the BS written down

        You must know that every number can be broken down in a multiplication of prime numbers, called it's prime factors.
        So, just assume we have this number 25 * 22. How many trailing zeros would it have?

                The answer lies in it's prime factors.
        25 = 5 * 5
        22 = 2 * 11

        A number will have a trailing zero, if and only if it has 10 as a factor, and for it to have 10 as a factor, it must have a pair of 2 and 5.
        In our above example, we see just one pair of 2 and 5, and hence 25 * 22 will have just one ttailing zero!

                How does it apply to a factorial? Well, 5! = 5 * 4 * 3 * 2 * 1 = 5 * (2 * 2) * 3 * 2 * 1 => just one pair of 2 and 5 again, and so one trailing zero.

        Noticed something? The number of 5 will always be less than the number of 2. So if we can find our the number of 5 amongst the prime factors of a number, that would give us the amount of trailing zeros.

        The big question though is how the hell do we find out all the prime factors of 1234! . I mean we can't do that, right?
        So we have this formula. To find the highest power of a prime factor in a factorial.

        Highest power of X(a prime number) in N! = [N/X] + [N/(X.X)] + [N / (X.X.X)] + . . . . + 0

        Highest power of 5 in 1234! ?

                1234/5 = 246
        246/5 = 49
        49/5 = 9
        9/5 = 1
        1/5 = 0

        246 + 49 + 9 + 1 = 305. Thus 1234! have 305 trailing zeros!

                Hope that helped you, and hope you learned something.
         */
        int ans = 0;

        while (n/5 > 0)
        {
            ans += n/5;
            n /= 5;
        }

        return ans;
    }
}
