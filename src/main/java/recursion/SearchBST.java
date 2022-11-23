package recursion;

import treenode.TreeNode;

public class SearchBST {
    static TreeNode answer = null;
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));
        System.out.println(treeNode);
        TreeNode search = searchBST2(treeNode, 2);
        System.out.println(search);
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if(answer != null)
            return answer;
        if(root == null || root.val == val)
            answer = root;
        if(root.left != null)
            searchBST(root.left, val);
        if(root.right != null)
            searchBST(root.right, val);
        return answer;
    }

    public static TreeNode searchBST2(TreeNode root, int val) {
        if (root == null || val == root.val)
            return root;

        if(val < root.val)
            return searchBST2(root.left, val);
        else
            return searchBST2(root.right, val);
    }
}
