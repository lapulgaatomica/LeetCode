package tries.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class WordDictionary {

    public static void main(String[] args) {
        WordDictionary trie = new WordDictionary();
        trie.addWord("apple");
        trie.addWord("ball");
//        System.out.println(trie.search("apple"));
//        System.out.println(trie.search("app"));
        System.out.println(trie.search("app."));
        System.out.println(trie.search("..."));
        System.out.println(trie.search("bapp"));
    }
    class TrieNode{
        public boolean isWord;
        public Map<Character, TrieNode> childrenMap = new HashMap<>();
    }
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!cur.childrenMap.containsKey(c))
                cur.childrenMap.put(c, new TrieNode());
            cur = cur.childrenMap.get(c);
        }
        cur.isWord = true;
    }

    public boolean searchInNode(String word, TrieNode cur) {
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (!cur.childrenMap.containsKey(c)) {
                if(c == '.'){
                    for (char key : cur.childrenMap.keySet()){
                        if(searchInNode(word.substring(i + 1), cur.childrenMap.get(key)))
                            return true;
                    }
                }
                return false;
            } else {
                cur = cur.childrenMap.get(c);
            }
        }
        return cur.isWord;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchInNode(word, root);
    }
}
