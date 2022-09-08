package easy4;

public class RepeatedSubstringPattern {
    //https://leetcode.com/problems/repeated-substring-pattern/submissions/
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
        System.out.println(repeatedSubstringPattern("aba"));
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
        System.out.println(repeatedSubstringPattern("abcdabcdabcdabcd"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        int lengthOfString = s.length();
        StringBuilder currentSubstring = new StringBuilder();
        for(int i = 0; i < lengthOfString / 2; i++){
            currentSubstring.append(s.charAt(i));
            StringBuilder possibleMatch = new StringBuilder();
            int amountOfTimeToRepeat = lengthOfString / (i + 1);
            for(int j = 0; j < amountOfTimeToRepeat; j++){
                possibleMatch.append(currentSubstring);
            }
            if(possibleMatch.toString().equals(s))
                return true;
        }
        return false;
    }

    public static boolean repeatedSubstringPattern2(String s) {
        String ss = s + s;
        ss = ss.substring(1, ss.length() - 1);
        return ss.contains(s);
    }
}
