package easy1;

public class ReverseString {
    public static void main(String[] args) {
//        char[] strings = new char[]{'h', 'e', 'l', 'l', 'o'};
        char[] strings = new char[]{'H', 'a','n','n','a','h'};
        reverseString(strings);

        for(char s: strings){
            System.out.println(s);
        }
    }

    public static void reverseString(char[] s) {
        int lengthOfString = s.length;
        int loop = lengthOfString / 2;

        for(int i = 0; i < loop; i++){
            int positionOfOppositeString = lengthOfString - 1 - i;
            char temp = s[i];
            s[i] = s[positionOfOppositeString];
            s[positionOfOppositeString] = temp;
        }
    }
}
