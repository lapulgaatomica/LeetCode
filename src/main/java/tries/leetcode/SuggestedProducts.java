package tries.leetcode;

import java.util.*;

public class SuggestedProducts {
    public static void main(String[] args) {
        System.out.println(suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse"));
        System.out.println(suggestedProducts(new String[]{"havana"}, "havana"));
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for(String product : products)
            trie.add(product);
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i < searchWord.length(); i++){
            List<String> suggestions = trie.getSuggestions(searchWord.substring(0, i + 1));
            ans.add(suggestions);
        }
        return ans;
    }

    static class Trie{
        class TrieNode{
            boolean isWord;
            Character character;
            Map<Character, TrieNode> children =new HashMap<>();
        }

        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }

        public void add(String word){
            TrieNode cur = root;
            for(int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if(!cur.children.containsKey(c))
                    cur.children.put(c, new TrieNode());
                cur = cur.children.get(c);
                cur.character = c;
            }
            cur.isWord = true;
        }

        public List<String> getSuggestions(String prefix){
            List<String> list = new ArrayList<>();
            TrieNode cur = root;
            for(char c : prefix.toCharArray()){
                if(!cur.children.containsKey(c))
                    return list;
                cur = cur.children.get(c);
            }

            if(cur.isWord)
                list.add(prefix);
            for(TrieNode child : cur.children.values()){
                get(child, prefix, list);
            }
            Collections.sort(list);
            List<String> ans = new ArrayList<>();
            for(int i = 0; i < 3 && i < list.size(); i++)
                ans.add(list.get(i));
            return ans;
        }

        public void get(TrieNode node, String prefix, List<String> list){
            prefix += node.character;
            if(node.isWord){
                list.add(prefix);
                if(!node.children.isEmpty()){
                    for(TrieNode trieNode : node.children.values()){
                        get(trieNode, prefix, list);
                    }
                }
                return;
            }
            for(TrieNode trieNode : node.children.values()){
                get(trieNode, prefix, list);
            }
        }
    }
}
