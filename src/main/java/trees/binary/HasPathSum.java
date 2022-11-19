package trees.binary;

public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        return recurse(root, 0, targetSum);
    }

    private boolean recurse(TreeNode root, int cumSum, int targetSum) {
        if(root == null)
            return cumSum == targetSum;
        else if (root.left == null && root.right != null) {
            return recurse(root.right, root.val + cumSum, targetSum);
        } else if (root.left != null && root.right == null) {
            return recurse(root.left, root.val + cumSum, targetSum);
        }
        return recurse(root.left, root.val + cumSum, targetSum) || recurse(root.right, root.val + cumSum, targetSum);
    }
}
