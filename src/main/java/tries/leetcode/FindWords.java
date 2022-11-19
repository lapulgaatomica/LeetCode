package tries.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindWords {
    public static void main(String[] args) {
//        System.out.println(findWords(new char[][]{{'a', 'b'}, {'c', 'd'}}, new String[]{"abcd"}));
//        System.out.println(findWords(new char[][]{{'a', 'a'}}, new String[]{"a"}));
        System.out.println(findWords(new char[][]{{'a', 'a'}}, new String[]{"aaa"}));
//        System.out.println(findWords(new char[][]{{'o', 'a', 'a', 'n'},
//                {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}},
//                new String[]{"oath","pea","eat","rain"}));
    }

    public static List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                str1.append(board[i][j]);
                if(j < board.length)
                    str2.append(board[j][i]);
            }
            trie.add(str1.toString());
            trie.add(str1.reverse().toString());
            trie.add(str2.toString());
            trie.add(str2.reverse().toString());
            str1 = new StringBuilder();
            str2 = new StringBuilder();
        }
        List<String> answer = new ArrayList<>();
        for(String word : words){
            if(trie.find(word))
                answer.add(word);
        }
        return answer;
    }

    static class Trie{
        class TrieNode{
            Map<Character, TrieNode> children = new HashMap<>();
        }

        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }

        public void add(String word){
            TrieNode current = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(!current.children.containsKey(c))
                    current.children.put(c, new TrieNode());
                current = current.children.get(c);
            }
        }

        public boolean find(String word){
            TrieNode current = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(!current.children.containsKey(c)){
                    if(i == 0)
                        return false;
                    current = root;
                    if(!current.children.containsKey(word.charAt(i - 1)))
                        return false;
                    current = current.children.get(word.charAt(i - 1));
                    if(!current.children.containsKey(c))
                        return false;
                }
                current = current.children.get(c);
            }
            return true;
        }
    }


}
