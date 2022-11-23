package recursion;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[] chars = {'h', 'e', 'l', 'l', 'o', 'z'};
        reverseString(chars);
        System.out.println(Arrays.toString(chars));
    }

    public static void reverseString(char[] s) {
        reverseString(0, s.length - 1, s);
    }

    public static void reverseString(int start, int end, char[] s) {
        if(start >= end)
            return;

        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        reverseString(start + 1, end - 1, s);
    }
}
