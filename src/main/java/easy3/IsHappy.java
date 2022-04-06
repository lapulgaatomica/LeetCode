package easy3;

import java.util.HashSet;
import java.util.Set;

public class IsHappy {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    public static boolean isHappy(int n) {
        // base case: can prove by induction, numbers less than 1000 can always have power sum < 10
        // for numbers > 1000, their power sums always have less digits (n-1, n-2) are true based on induction
        Set<Integer> visited = new HashSet<>();
        while(true) {
            int sum = 0;
            while(n != 0) {
                sum += Math.pow(n % 10, 2);
                n /= 10;
            }
            n = sum;
            // the sum of digits power will always become smaller untill less than 10, so only need to remember the visited number < 10
            if (n < 10) {
                if (n == 1) {
                    return true;
                }
                else if (visited.contains(n)) {
                    break;
                }
                visited.add(n);
            }
        }
        return false;
    }
}
