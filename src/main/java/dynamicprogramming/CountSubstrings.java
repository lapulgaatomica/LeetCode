package dynamicprogramming;

public class CountSubstrings {
    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));
        System.out.println(countSubstrings("aaa"));
    }

    public static int countSubstrings(String s) {
        int ans = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                if(checkPalindrome(s, i, j))
                    ans++;
            }

        }
        return ans;
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
