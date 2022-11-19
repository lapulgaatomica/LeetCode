package tries.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReplaceWords {
    public static void main(String[] args) {
        System.out.println(replaceWords(List.of("cat","bat","rat"), "the cattle was rattled by the battery"));
        System.out.println(replaceWords(List.of("a","b","c"), "aadsfasf absbs bbab cadsfafs"));
    }

    public static String replaceWords(List<String> dictionary, String sentence) {
        ReplaceWordsTrie trie = new ReplaceWordsTrie();
        for(String word : dictionary)
            trie.insert(word);

        StringBuilder stringBuilder = new StringBuilder();
        String[] strings = sentence.split(" ");
        for(String string : strings){
            StringBuilder inner = new StringBuilder();
            for(char c : string.toCharArray()){
                inner.append(c);
                if(!trie.startsWith(inner.toString())){
                    stringBuilder.append(string);
                    inner = new StringBuilder();
                    break;
                }
                if(trie.search(inner.toString())){
                    stringBuilder.append(inner);
                    inner = new StringBuilder();
                    break;
                }
            }
            stringBuilder.append(inner).append(" ");
        }
        return stringBuilder.toString().trim();
    }
}

class ReplaceWordsTrie {
    class TrieNode {
        public boolean isWord;
        public Map<Character, TrieNode> childrenMap = new HashMap<>();
    }

    private TrieNode root;

    public ReplaceWordsTrie(){
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode cur = root;

        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.childrenMap.get(c) == null){
                cur.childrenMap.put(c, new TrieNode());
            }
            cur = cur.childrenMap.get(c);
        }
        cur.isWord = true;
    }

    public boolean search(String word){
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.childrenMap.get(c) == null)
                return false;
            cur = cur.childrenMap.get(c);
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix){
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(cur.childrenMap.get(c) == null)
                return false;
            cur = cur.childrenMap.get(c);
        }
        return true;
    }
}
