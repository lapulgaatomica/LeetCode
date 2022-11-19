package trees.nary;

public class MaxDepth {
    int maxDepth = 0;
    public int maxDepth(Node root) {
        if(root == null)
            return 0;
        return recurse(root, 1);
    }

    private int recurse(Node root, int currentDepth) {
        if(root == null)
            return 0;
        maxDepth = Math.max(maxDepth, currentDepth);
        for(Node child : root.children)
            maxDepth = Math.max(maxDepth, recurse(child, currentDepth + 1));
        return maxDepth;
    }
}
