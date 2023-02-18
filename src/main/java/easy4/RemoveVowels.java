package easy4;

import java.util.HashSet;
import java.util.Set;

public class RemoveVowels {
    public static void main(String[] args) {

    }

    public String removeVowels(String s) {
        StringBuilder ans = new StringBuilder();
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');vowels.add('e');vowels.add('i');vowels.add('o');vowels.add('u');
        for(char ch : s.toCharArray()){
            if(!vowels.contains(ch))
                ans.append(ch);
        }
        return ans.toString();
    }
}
