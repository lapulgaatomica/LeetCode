package tries.implementtrie;

public class TrieTest {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("dele");
        System.out.println(trie.search("del"));
        System.out.println(trie.search("dele"));
        System.out.println(trie.startsWith("d"));
        System.out.println(trie.startsWith("de"));
        System.out.println(trie.startsWith("del"));
        System.out.println(trie.startsWith("dele"));
        System.out.println(trie.startsWith("delee"));
    }
}
