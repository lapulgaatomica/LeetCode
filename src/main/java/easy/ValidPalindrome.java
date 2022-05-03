package easy;

public class ValidPalindrome {
    public static void main(String[] args) {
//        System.out.println(isPalindrome2("aba"));
//        System.out.println(isPalindrome2("A man, a plan, a canal: Panama"));
//        System.out.println(isPalindrome2("a,a,b,ba.a"));
//        System.out.println(isPalindrome2("8V8K;G;K;V;"));
        System.out.println(isPalindrome3("abca"));
        System.out.println(isPalindrome3("aba"));
        System.out.println(isPalindrome3("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
        System.out.println(isPalindrome3("abc"));
        System.out.println(isPalindrome3("axbcbaba"));

    }

    public static boolean isPalindrome(String s) {
        //https://leetcode.com/problems/valid-palindrome
        s = s.replaceAll("\\s|[^a-zA-Z0-9]","").toLowerCase();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome2(String s) {
        //https://leetcode.com/problems/valid-palindrome
        int left = 0;
        int right = s.length() - 1;

        while (left < right){
            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));
            if(leftChar != rightChar){
                if(Character.isLetterOrDigit(leftChar) && Character.isLetterOrDigit(rightChar)) {
                    return false;
                }
                if(!Character.isLetterOrDigit(leftChar))
                    left++;
                if(!Character.isLetterOrDigit(rightChar))
                    right--;
            }else{
                left++;
                right--;
            }
        }
        return true;
    }

    public static boolean isPalindrome3(String s) {
        //https://leetcode.com/problems/valid-palindrome-ii/
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            if(s.charAt(left) != s.charAt(right)){
                return checkPalindrome(s, left + 1, right) || checkPalindrome(s, left, right - 1);
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean checkPalindrome(String s, int left, int right){
        while (left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
