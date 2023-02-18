package trees.binary;

public class DeepestLeavesSum {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6, new TreeNode(7, new TreeNode(2, new TreeNode(9), null), new TreeNode(7, new TreeNode(1), new TreeNode(4))), new TreeNode(8, new TreeNode(1), new TreeNode(3, null, new TreeNode(5))));
        int sum = deepestLeavesSum(root);
        System.out.println(sum);
    }

    static int height = 0;
    static int sm = 0;
    public static int deepestLeavesSum(TreeNode root) {
        getHeight(root, 1);
        sum(root, 1);
        return sm;
    }

    private static void sum(TreeNode root, int currHeight){
        if(root == null)
            return;
        if(currHeight == height)
            sm += root.val;
        sum(root.left, currHeight + 1);
        sum(root.right, currHeight + 1);
    }

    private static void getHeight(TreeNode root, int currHeight){
        if(root == null)
            return;
        if(currHeight > height)
            height = currHeight;
        getHeight(root.left, currHeight + 1);
        getHeight(root.right, currHeight + 1);
    }
}
