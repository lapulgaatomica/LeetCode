package trees.binary;

public class CountUnivalSubtrees {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(1), new TreeNode(5));
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(5);
        System.out.println(countUnivalSubtrees(root));
    }
    private static int count = 0;

    public static int countUnivalSubtrees(TreeNode root) {
        if(root == null)
            return 0;
        isUni(root);
        return count;
    }

    private static boolean isUni(TreeNode node) {
        //base case - if the node has no children this is a univalue subtree
        if(node.left == null && node.right == null){
            count++;
            return true;
        }
        boolean isUnival = true;

        // check if all the node's children are univalue subtrees and if they have the same value
        // also recursively call is_uni for children
        if(node.left != null)
            isUnival = isUni(node.left) && isUnival && node.left.val == node.val;

        if(node.right != null)
            isUnival = isUni(node.right) && isUnival && node.right.val == node.val;

        if(!isUnival)
            return false;
        count++;
        return true;
    }
}
