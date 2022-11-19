package tries.leetcode;

public class Test {
    public static void main(String[] args) {
        ReplaceWordsTrie trie = new ReplaceWordsTrie();
        trie.insert("apple");
        trie.search("apple");
        trie.search("app");
        trie.startsWith("app");
        trie.insert("app");
        trie.search("app");
    }
}
