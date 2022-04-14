package unaccepted;

public class GetSmallestString {
    public static void main(String[] args) {
//        System.out.println(getSmallestString(3, 27));
//        System.out.println(getSmallestString(5, 23));
        System.out.println(getSmallestString(5, 73));
//        System.out.println(27 % 26);
//        System.out.println(27 / 26);
//        System.out.println(73 % 26);
//        System.out.println(73 / 26);
//        System.out.println(2 / 26);
//        System.out.println(2 % 26);
    }

    public static String getSmallestString(int n, int k) {
        char[] chs = new char[n];
        for(int i = n - 1; i >= 0; i--){
            if(k - i <= 26){
                chs[i] = (char)((k - i - 1) + 'a');
                k = i;
            }else{
                chs[i] = 'z';
                k -= 26;
            }
        }
        return String.valueOf(chs);
    }
}
