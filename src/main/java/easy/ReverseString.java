package easy;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        reverseString(chars);
        System.out.println(Arrays.toString(chars));
    }

    public static void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;

        while (start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}
