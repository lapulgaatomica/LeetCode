package tries.leetcode;

import java.util.HashMap;
import java.util.Map;

public class FileSystem {
    class TrieNode{
        Integer val;
        Map<String, TrieNode> children = new HashMap<>();
    }
    TrieNode root;
    public FileSystem() {
        root = new TrieNode();
    }

    public boolean createPath(String path, int value) {
        String[] paths = path.split("/");
        TrieNode cur = root;
        for(int i = 1; i < paths.length; i++){
            if(!cur.children.containsKey(paths[i])){
                if(i != paths.length - 1)
                    return false;
                else
                    cur.children.put(paths[i], new TrieNode());
            }
            cur = cur.children.get(paths[i]);
        }
        if(cur.val != null)
            return false;
        cur.val = value;
        return true;
    }

    public int get(String path) {
        String[] paths = path.split("/");
        TrieNode cur = root;
        for(int i = 0; i < paths.length; i++){
            if(i == 0)
                continue;
            if(!cur.children.containsKey(paths[i]))
                return -1;
            cur = cur.children.get(paths[i]);
        }
        return cur.val;
    }

    public static void main(String[] args) {
//        FileSystem fileSystem = new FileSystem();
//
//        System.out.println(fileSystem.createPath("/a", 1)); // return true
//        System.out.println(fileSystem.get("/a")); // return 1

        FileSystem system = new FileSystem();

        system.createPath("/leet", 1); // return true
        system.createPath("/leet/code", 2); // return true
        system.get("/leet/code"); // return 2
        system.createPath("/c/d", 1); // return false because the parent path "/c" doesn't exist.
        system.get("/c"); // return -1 because this path doesn't exist.
    }
}
