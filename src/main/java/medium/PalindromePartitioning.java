package medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    //https://leetcode.com/problems/palindrome-partitioning/
    public static void main(String[] args) {
        System.out.println(partition("aab"));
        System.out.println(partition("aaa"));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(0, result, new ArrayList<>(), s);
        return result;
    }

    private static void dfs(int start, List<List<String>> result, List<String> currentList, String s) {
        if (start >= s.length())
            result.add(new ArrayList<>(currentList));

        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                // add current substring in the currentList
                currentList.add(s.substring(start, end + 1));
                dfs(end + 1, result, currentList, s);
                // backtrack and remove the current substring from currentList
                currentList.remove(currentList.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int left, int right){
        while (left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
