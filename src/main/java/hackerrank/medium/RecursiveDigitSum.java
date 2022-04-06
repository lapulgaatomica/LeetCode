package hackerrank.medium;

public class RecursiveDigitSum {
    public static void main(String[] args) {
        System.out.println(superDigit("123", 3) == 9);
        System.out.println(superDigit("148", 3) == 3);
        System.out.println(superDigit("9875", 4) == 8);
    }

    public static int superDigit(String n, int k) {
        long ans = 0;
        if(n.length() == 1){
            return Integer.parseInt(n) * k;
        }
        for(int i = 0; i < n.length(); i++){
            ans += superDigit(String.valueOf(n.charAt(i)), k);
        }
        if(ans > 9){
            return superDigit(String.valueOf(ans), 1);
        }else{
            return (int) ans;
        }
    }
}
