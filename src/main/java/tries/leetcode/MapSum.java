package tries.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
    class TrieNode{
        int sum;
        Map<Character, TrieNode> children = new HashMap<>();
    }

    TrieNode root;
    Map<String, Integer> map;
    public MapSum() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int toAdd = val - map.getOrDefault(key, 0);
        map.put(key, val);
        TrieNode cur = root;
        cur.sum += toAdd;

        for(int i = 0; i < key.length(); i++){
            char c = key.charAt(i);
            if(!cur.children.containsKey(c))
                cur.children.put(c, new TrieNode());
            cur = cur.children.get(c);
            cur.sum += toAdd;
        }
    }

    public int sum(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(!cur.children.containsKey(c))
                return 0;
            cur = cur.children.get(c);
        }
        return cur.sum;
    }
}
