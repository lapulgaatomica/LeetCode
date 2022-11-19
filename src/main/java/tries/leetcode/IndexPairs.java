package tries.leetcode;

import java.util.*;

public class IndexPairs {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(indexPairs("thestoryofleetcodeandme", new String[]{"story","fleet","leetcode"})));
        System.out.println(Arrays.toString(indexPairs("ababa", new String[]{"aba","ab"})));
    }

    public static int[][] indexPairs(String text, String[] words) {
        Trie trie = new Trie();
        for(String word : words)
            trie.add(word);
        List<Integer[]> list = new ArrayList<>();
        for(int i = 0; i < text.length(); i++){
            for(int j = i; j < text.length(); j++){
                if(trie.find(text.substring(i, j + 1))){
                    list.add(new Integer[]{i, j});
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }

    static class Trie{
        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }

        class TrieNode{
            boolean isWord;
            Map<Character, TrieNode> childrenMap = new HashMap<>();
        }

        public void add(String word){
            TrieNode current = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(!current.childrenMap.containsKey(c))
                    current.childrenMap.put(c, new TrieNode());
                current = current.childrenMap.get(c);
            }
            current.isWord = true;
        }

        public boolean find(String word){
            TrieNode current = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(!current.childrenMap.containsKey(c))
                    return false;
                current = current.childrenMap.get(c);
            }
            return current.isWord;
        }
    }
}
