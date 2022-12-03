package recursion;

import treenode.TreeNode;

public class IsValidBST {
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(isValidBST(treeNode1));
        TreeNode treeNode2 = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        System.out.println(isValidBST(treeNode2));
        TreeNode treeNode3 = new TreeNode(5, new TreeNode(4), new TreeNode(6, new TreeNode(3), new TreeNode(7)));
        System.out.println(isValidBST(treeNode3));
    }

    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private static boolean validate(TreeNode root, Integer low, Integer high) {
        if(root == null)
            return true;

        if((low != null && root.val <= low) || (high != null && root.val >= high))
            return false;

        return validate(root.left, low, root.val) && validate(root.right, root.val, high);
    }
}
