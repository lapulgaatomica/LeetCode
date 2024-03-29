package freestyle;

public class MyAtoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("   -42"));
        System.out.println(myAtoi("   -99999999999999999999"));
    }

    public static int myAtoi(String s) {
        int sign = 1;
        int result = 0;
        int index = 0;
        int n = s.length();

        while (index < n && s.charAt(index) == ' ')
            index++;

        if(index < n && s.charAt(index) == '+'){
            sign = 1;
            index++;
        } else if (index < n && s.charAt(index) == '-') {
            sign = -1;
            index++;
        }

        while (index < n && Character.isDigit(s.charAt(index))){
            int digit = s.charAt(index) - '0';

            if((result > Integer.MAX_VALUE / 10) || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            result = 10 * result + digit;
            index++;
        }
        return sign * result;
    }
}
