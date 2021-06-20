package easy1;

public class PowerOfFour {
    public static void main(String[] args) {
        for(int i = 0; i <= 256; i++){
            System.out.println(i + " " + isPowerOfFour(i));
        }
    }

    public static boolean isPowerOfFour(int n) {
        while(n != 0){
            if(n == 1)
                return true;
            if(n % 4 == 0)
                n = n/4;
            else
                return false;
        }

        return false;
    }
}
