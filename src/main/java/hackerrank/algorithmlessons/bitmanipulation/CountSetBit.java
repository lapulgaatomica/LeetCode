package hackerrank.algorithmlessons.bitmanipulation;

public class CountSetBit {
    private static int helper(int n) {
        //Write a Java program to count the number of bits set to 1 (set bits) of an integer.
        int count = 0;
        while (n > 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int number = 125;
        System.out.println("SetBit Count is : " + helper(number));
    }
}
