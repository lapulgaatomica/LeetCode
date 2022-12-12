package binarysearchtree;

public class InorderSuccessor {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        TreeNode treeNode2 = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6));
        TreeNode treeNode1Successor = inorderSuccessor(treeNode1, new TreeNode(1));
        TreeNode treeNode2Successor = inorderSuccessor(treeNode2, new TreeNode(6));
        System.out.println();
    }

    public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
         helper(root, p);
         return successor;
    }
    static TreeNode successor = null;
    static boolean predecessorFound = false;

    private static void helper(TreeNode root, TreeNode p) {
        if(successor == null && root != null && root.left != null)
            helper(root.left, p);
        if(predecessorFound && successor == null)
            successor = root;
        else if(successor != null)
            return;
        if(!predecessorFound && root != null && p != null && p.val == root.val)
            predecessorFound = true;
        if(successor == null && root != null && root.right != null)
            helper(root.right, p);
    }
}
