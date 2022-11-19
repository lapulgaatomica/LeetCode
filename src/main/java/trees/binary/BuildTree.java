package trees.binary;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    static int postIndex;
    static int[] postOrder;
    static int[] inOrder;
    static Map<Integer, Integer> indexMap = new HashMap<>();
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrder = postorder;
        inOrder = inorder;
        postIndex = postorder.length - 1;

        int index = 0;
        for(int val : inorder)
            indexMap.put(val, index++);

        return helper(0, inorder.length - 1);
    }

    private static TreeNode helper(int left, int right) {
        if(left > right)
            return null;

        int rootVal = postOrder[postIndex];
        TreeNode root = new TreeNode(rootVal);

        int index = indexMap.get(rootVal);
        postIndex--;
        root.right = helper(index + 1, right);
        root.left = helper(left, index - 1);
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println();
    }
}
