package tries.algoexpert;

import java.util.HashMap;
import java.util.Map;

public class Program {
    public static void main(String[] args) {
        SuffixTrie trie = new SuffixTrie("babc");
        System.out.println(trie.contains("abc"));
    }
    // Do not edit the class below except for the
    // populateSuffixTrieFrom and contains methods.
    // Feel free to add new properties and methods
    // to the class.
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
            return current.children.containsKey(endSymbol);
        }
    }
}