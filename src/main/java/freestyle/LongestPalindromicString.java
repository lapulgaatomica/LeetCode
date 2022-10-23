package freestyle;

public class LongestPalindromicString {
    public static void main(String[] args) {
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {
        String longest = "";

        for(int i = 0; i < s.length(); i++){
            int rightPointer = s.length() - 1;
            while (rightPointer >= i && rightPointer - i >= longest.length()){
                boolean isPalindrome = checkPalindrome(s, i, rightPointer);
                if(isPalindrome){
                    if(rightPointer - i >= longest.length())
                        longest = s.substring(i, rightPointer + 1);
                }
                rightPointer--;
            }
        }
        return longest;
    }

    private static boolean checkPalindrome(String s, int left, int right){
        while (left <= right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
