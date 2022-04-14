package unaccepted;

public class GetSmallestString {
    public static void main(String[] args) {
        System.out.println(getSmallestString(5, 73));
    }

    public static String getSmallestString(int n, int k){
        char[] chars = new char[n];

        for(int i = n - 1; i >= 0; i--){
            if(k - i > 26){
                chars[i] = 'z';
                k -= 26;
            }else{
                chars[i] = (char)((k - i - 1) + 'a');
                k = i;
            }
        }
        return String.valueOf(chars);
    }
}
