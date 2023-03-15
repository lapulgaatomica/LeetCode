package medium;

public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
        System.out.println(repeatedSubstringPattern("aba"));
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        StringBuilder sub = new StringBuilder();
        for(int i = 0; i < length / 2; i++){
            sub.append(s.charAt(i));
            StringBuilder temp = new StringBuilder();
            for(int j = 0; j < s.length() / sub.length(); j++){
                temp.append(sub);
            }
            if(temp.toString().equals(s))
                return true;
        }
        return false;
    }
}
