package trees.binary;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
                new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        TreeNode lca = lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4));
        System.out.println();
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        if (root.val == p.val || root.val == q.val) { // key is here, especially when p is parent of q or vice-versa
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        } else if (left == null && right == null) {
            return null;
        } else if (left == null && right != null) {
            return right;
        } else { // left != null && right == null
            return left;
        }
    }
}
