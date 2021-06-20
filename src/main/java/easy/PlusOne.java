package easy;

public class PlusOne {
    public static void main(String[] args) {
//        System.out.println(plusOne(new int[]{1, 2, 9}));
        System.out.println(plusOne(new int[]{9}));
//        System.out.println(plusOne(new int[]{4, 3, 2, 1}));
//        System.out.println(plusOne(new int[]{0}));
    }

    public static int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] != 9){
                digits[i] += 1;
                break;
            }else{
                if(i == 0){
                    int[] newArray = new int[digits.length + 1];
                    newArray[0] = 1;
                    newArray[1] = 0;
                }else{
                    digits[i] = 0;
                }
            }
        }
        for(int i: digits){
            System.out.print(i);
        }
        return digits;
    }
}
