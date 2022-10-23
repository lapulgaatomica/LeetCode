package easy;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverseInteger(321));
        System.out.println(reverseInteger(-321));
    }

    private static int reverseInteger(int number) {
        long num = number;
        long reverse = 0;

        while (num != 0){
            reverse = (reverse * 10) +  (num % 10) ;
            num = num / 10;
        }

        if(reverse <= Integer.MIN_VALUE || reverse >= Integer.MAX_VALUE){
            return 0;
        }else{
            return (int) reverse;
        }
    }
}
