package dynamicprogramming;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abde", "ace"));
        System.out.println(longestCommonSubsequence("abc", "abc"));
        System.out.println(longestCommonSubsequence("abc", "def"));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        return dp(text1, text2, 0,text1.length() - 1, text2.length() - 1);
    }

    private static int dp(String text1, String text2, int answer, int first, int second) {
        if(first < 0 || second < 0)
            return answer;

        if(text1.charAt(first) == text2.charAt(second))
            return dp(text1, text2, answer + 1, first - 1, second - 1);
        else
            return answer + dp(text1, text2, 0, first, second);
    }
}
