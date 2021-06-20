package easy;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverseInteger(321));

        System.out.println(Long.MIN_VALUE);
    }

    private static int reverseInteger(int number) {
        long num = number;
        long reverse = 0;
        long reps = 1;
        do {
            reverse = (reverse * reps) +  (num % 10) ;
            num = num / 10;
            reps = 10;
        }while (num != 0);
        if(reverse <= Integer.MIN_VALUE || reverse >= Integer.MAX_VALUE){
            return 0;
        }else{
            return (int) reverse;
        }
    }
}
