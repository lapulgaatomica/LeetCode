package easy;

public class PalindroneNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
        System.out.println(reverseInteger(10));
    }

    public static boolean isPalindrome(int x) {
        int reverse = reverseInteger(x);
        if (x == reverse && Math.abs(x) == x){
            return true;
        }
        return false;
    }

    private static int reverseInteger(int number) {
        long num = number;
        long reverse = 0;
        long reps = 10;
        while (num != 0){
            reverse = (reverse * reps) +  (num % 10) ;
            num = num / 10;
        }

        if(reverse <= Integer.MIN_VALUE || reverse >= Integer.MAX_VALUE){
            return 0;
        }else{
            return (int) reverse;
        }
    }
}
