package easy2;

public class RotateString {
    public static void main(String[] args) {
        // https://leetcode.com/problems/rotate-string/
        System.out.println(rotateString("abcde", "cdeab"));
        System.out.println(rotateString("abcde", "abced"));
    }

    public static boolean rotateString(String s, String goal) {
        StringBuilder stringBuilder = new StringBuilder(s);
        int lengthOfString = s.length();

        for(int i = 0; i < lengthOfString; i++){
            stringBuilder.insert(0, stringBuilder.charAt(lengthOfString - 1));
            stringBuilder.replace(lengthOfString, lengthOfString + 1, "");
            if(stringBuilder.toString().equals(goal)){
                return true;
            }
        }

        return false;
    }
}
