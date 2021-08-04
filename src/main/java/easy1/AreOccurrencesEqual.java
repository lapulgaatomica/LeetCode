package easy1;

import java.util.*;
import java.util.stream.Collectors;

public class AreOccurrencesEqual {
    public static void main(String[] args) {
        // https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences/
        System.out.println(areOccurrencesEqual("abacbc"));
        System.out.println(areOccurrencesEqual("aaabb"));
    }

    public static boolean areOccurrencesEqual(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char current = s.charAt(i);
            map.put(current, map.getOrDefault(current, 0) + 1);
        }

        return new HashSet<>(map.values()).size() == 1;
    }
}
