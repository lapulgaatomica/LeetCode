package easy3;

public class HammingWeight {
    public static void main(String[] args) {
        //https://leetcode.com/problems/number-of-1-bits/
        System.out.println(hammingWeight(00000000000000000000000000001011));
        System.out.println(hammingWeight(00000000000000000000000010000000));
        System.out.println(hammingWeight(0100));
    }

    public static int hammingWeight(int n) {
        int hw = 0;
        while (n != 0) {
            if (n < 0)
                hw++; // negative n means the leftmost bit is 1
            n <<= 1;
        }
        return hw;
    }
}
