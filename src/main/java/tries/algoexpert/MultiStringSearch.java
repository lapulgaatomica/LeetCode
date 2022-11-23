package tries.algoexpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiStringSearch {
    public static void main(String[] args) {
        System.out.println(multiStringSearch("this is a big string",
                new String[]{"this", "yo", "is", "a", "bigger", "string", "kappa"}));//tfttftf
        System.out.println(multiStringSearch("abcdefghijklmnopqrstuvwxyz",
                new String[]{"abc", "mnopqr", "wyz", "no", "e", "tuuv"}));//ttfttf
    }

    public static List<Boolean> multiStringSearch(String bigString, String[] smallStrings) {
        SuffixTrie trie = new SuffixTrie(bigString);
        List<Boolean> answer = new ArrayList<>();
        for(String string : smallStrings)
            answer.add(trie.contains(string));
        return answer;
    }

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String str) {
            for(int i = 0; i < str.length(); i++){
                String currentStr = str.substring(i);
                TrieNode current = root;
                for(int j = 0; j < currentStr.length(); j++){
                    char c = currentStr.charAt(j);
                    if(!current.children.containsKey(c))
                        current.children.put(c, new TrieNode());
                    current = current.children.get(c);
                }
                current.children.put(endSymbol, null);
            }
        }

        public boolean contains(String str) {
            TrieNode current = root;

            for(int i = 0; i < str.length(); i++){
                char c = str.charAt(i);
                if(!current.children.containsKey(c))
                    return false;
                current = current.children.get(c);
            }
            return true;
        }
    }
}
