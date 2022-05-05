package unaccepted;

public class BuddyStrings {
    public static void main(String[] args) {
        // https://leetcode.com/problems/buddy-strings/
        System.out.println(buddyStrings("ab", "ba"));
        System.out.println(!buddyStrings("ab", "ab"));
        System.out.println(buddyStrings("aa", "aa"));
        System.out.println(buddyStrings("aaaaaaabc", "aaaaaaacb"));
        System.out.println(buddyStrings("abab", "abab"));
        System.out.println(!buddyStrings("abcd", "abcd"));
        System.out.println(!buddyStrings("abab", "acaa"));
    }

    public static boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        if (s.equals(goal)) {
            int[] count = new int[26];
            for (int i = 0; i < s.length(); ++i)
                count[s.charAt(i) - 'a']++;

            for (int c: count)
                if (c > 1)
                    return true;
            return false;
        } else {
            int first = -1, second = -1;
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) != goal.charAt(i)) {
                    if (first == -1)
                        first = i;
                    else if (second == -1)
                        second = i;
                    else
                        return false;
                }
            }

            return (second != -1 && s.charAt(first) == goal.charAt(second) && s.charAt(second) == goal.charAt(first));
        }
    }
}
