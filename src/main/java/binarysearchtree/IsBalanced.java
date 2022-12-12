package binarysearchtree;

public class IsBalanced {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        boolean oBalanciaga = isBalanced(root);
        TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)), new TreeNode(2));
        boolean koBalanciaga = isBalanced(node);
        System.out.println();
    }

    public static boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        int leftHeight = getHeight(root.left, 0);
        int rightHeight = getHeight(root.right, 0);

        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int getHeight(TreeNode node, int curr){
        if(node == null)
            return 0;
        int left = getHeight(node.left, curr) + 1;
        int right = getHeight(node.right, curr) + 1;
        return Math.max(right, left);
    }
}
