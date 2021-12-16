package easy3;

import java.util.HashSet;
import java.util.Set;


public class CountVowelSubstrings {
    //https://leetcode.com/problems/count-vowel-substrings-of-a-string/
    public static void main(String[] args) {
        System.out.println(countVowelSubstrings("aeiouu"));
        System.out.println(countVowelSubstrings("unicornarihan"));
        System.out.println(countVowelSubstrings("cuaieuouac"));
        System.out.println(countVowelSubstrings("bbaeixoubb"));
    }

    public static int countVowelSubstrings(String word) {
        int count = 0;
        Set<Character> allVowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> temp = new HashSet<>();

        for(int i = 0; i < word.length(); i++){
            char currentChar = word.charAt(i);
            if (allVowels.contains(currentChar)) {
                temp.add(currentChar);
                for (int j = i + 1; j < word.length(); j++) {
                    currentChar = word.charAt(j);
                    if (!allVowels.contains(currentChar)) {
                        break;
                    } else {
                        temp.add(currentChar);
                        if (temp.equals(allVowels)) {
                            count++;
                        }
                    }
                }
            }
            temp = new HashSet<>();
        }

        return count;
    }
}
