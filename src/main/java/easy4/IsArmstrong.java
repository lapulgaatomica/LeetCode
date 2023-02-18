package easy4;

public class IsArmstrong {
    public static void main(String[] args) {
        System.out.println(isArmstrong(153));
        System.out.println(isArmstrong(123));
    }

    public static boolean isArmstrong(int n) {
        int numberOfKs = String.valueOf(n).length();
        int kthDigit = 0;
        int tempN = n;

        while (tempN > 0){
            int curr = tempN % 10;
            int num = 1;
            for(int i = 0; i < numberOfKs; i++)
                num *= curr;
            kthDigit += num;
            tempN /= 10;
        }
        return kthDigit == n;
    }
}
