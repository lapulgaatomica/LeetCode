package medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class LongestStrChain {
    public static void main(String[] args) {
//        System.out.println(longestStrChain2(new String[]{"xbc","pcxbcf","xb","cxbc","pcxbc"}));
//        System.out.println(longestStrChain2(new String[]{"a","b","ba","bca","bda","bdca"}));
//        System.out.println(longestStrChain2(new String[]{"abcd","dbqca"}));
//        System.out.println(longestStrChain2(new String[]{"bdca","bda","ca","dca","a"}));
        System.out.println(longestStrChain2(new String[]{"a","ab","ac","bd","abc","abd","abdd"}));
    }
    public static int longestStrChain2(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int longestWordSequenceLength = 1;
        for (String word : words) {
            int presentLength = 1;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder temp = new StringBuilder(word);
                temp.deleteCharAt(i);
                String predecessor = temp.toString();
                int previousLength = dp.getOrDefault(predecessor, 0);
                presentLength = Math.max(presentLength, previousLength + 1);
            }
            dp.put(word, presentLength);
            longestWordSequenceLength = Math.max(longestWordSequenceLength, presentLength);
        }
        return longestWordSequenceLength;
    }
}
