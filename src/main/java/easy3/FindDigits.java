package easy3;

public class FindDigits {
    public static void main(String[] args) {
        System.out.println(findDigits(1012));
        System.out.println(findDigits(12));
    }

    public static int findDigits(int n) {
        int temp = n;
        int answer = 0;

        while (temp != 0){
            int currentDigit = temp  % 10;
            if( currentDigit != 0 && n % currentDigit == 0){
                answer++;
            }
            temp /= 10;
        }
        return answer;
    }
}
