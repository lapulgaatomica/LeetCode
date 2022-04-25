package easy;

public class FirstPalindrome {
    public static void main(String[] args) {
        System.out.println(firstPalindrome(new String[]{"abc","car","ada","racecar","cool"}));
        System.out.println(firstPalindrome(new String[]{"notapalindrome","racecar"}));
        System.out.println(firstPalindrome(new String[]{"def","ghi"}));
    }

    public static String firstPalindrome(String[] words) {
        for (String word : words){
            if(isPalindrome(word))
                return word;
        }
        return "";
    }

    public static boolean isPalindrome(String word){
        int left = 0;
        int right = word.length() - 1;

        while (left < right){
            if(word.charAt(left) != word.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
