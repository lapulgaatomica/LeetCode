package trees.binary;

import java.util.List;

public class MaxDepth {
    //https://leetcode.com/problems/maximum-depth-of-n-ary-tree/

    public static int maxDepth(Node root) {
        int maxDepth = 0;
        if(root == null){
            return 0;
        }

        for(Node child : root.children){
            maxDepth = Math.max(maxDepth, maxDepth(child));
        }

        return maxDepth + 1;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}