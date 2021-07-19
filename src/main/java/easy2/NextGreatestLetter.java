package easy2;

public class NextGreatestLetter {
    public static void main(String[] args) {
        //https://leetcode.com/problems/find-smallest-letter-greater-than-target
        System.out.println(nextGreatestLetter(new char[]{'c','f','j'}, 'a') == 'c');
        System.out.println(nextGreatestLetter(new char[]{'c','f','j'}, 'c') == 'f');
        System.out.println(nextGreatestLetter(new char[]{'c','f','j'}, 'd') == 'f');
        System.out.println(nextGreatestLetter(new char[]{'c','f','j'}, 'g' ) == 'j');
        System.out.println(nextGreatestLetter(new char[]{'c','f','j'}, 'j') == 'c');
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        for (char letter : letters) {
            if (letter - target > 0) {
                return letter;
            }
        }
        return letters[0];
    }
}
