package binarysearchtree;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6, new TreeNode(2, new TreeNode(0), new TreeNode(4)), new TreeNode(8, new TreeNode(7), new TreeNode(9)));
        TreeNode lca = lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8));
        TreeNode lca2 = lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4));
        System.out.println();
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> pSet = new LinkedList<>();
        LinkedList<TreeNode> qSet = new LinkedList<>();
        helper(root, p, pSet);
        helper(root, q, qSet);
        for (int i = qSet.size() - 1; i >= 0; i--){
            if(pSet.contains(qSet.get(i)))
                return qSet.get(i);
        }
        return null;
    }

    private static void helper(TreeNode root, TreeNode searchNode, LinkedList<TreeNode> set) {
        if(root.val == searchNode.val){
            set.add(root);
            return;
        }
        if(root.val < searchNode.val){
            set.add(root);
            helper(root.right, searchNode, set);
        }else{
            set.add(root);
            helper(root.left, searchNode, set);
        }
    }
}
