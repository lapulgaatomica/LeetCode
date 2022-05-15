package hackerrank.easy;

public class BetweenTwoSets {
    public static void main(String[] args) {
        System.out.println(getTotalX(new int[]{2, 4}, new int[]{16, 32, 96}));
    }

    public static int gcd(int a, int b) {
        while (a > 0 && b > 0) {
            if (a >= b) {
                a = a % b;
            }
            else {
                b = b % a;
            }
        }
        return a + b;
    }

    public static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    public static int getTotalX(int[] a, int[] b) {
        int multiple = 0;
        for(int i : b) {
            multiple = gcd(multiple, i);
        }

        int factor = 1;
        for(int i : a) {
            factor = lcm(factor, i);
            if (factor > multiple) {
                return 0;
            }
        }

        if (multiple % factor != 0) {
            return 0;
        }

        int totalX = 1;

        for (int i = factor; i < multiple; i++) {
            if (multiple % i == 0 && i % factor == 0) {
                totalX++;
            }
        }
        return totalX;
    }
}
