package trees.binary;

import java.util.HashMap;
import java.util.Map;

public class ConstructTree {
    static int preIndex;
    static int[] preOrder;
    static int[] inOrder;
    static Map<Integer, Integer> inOrderIndexMap = new HashMap<>();

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        preOrder = preorder;
        inOrder = inorder;

        for(int i = 0; i < inorder.length; i++)
            inOrderIndexMap.put(inorder[i], i);

        return helper(0, preorder.length - 1);
    }
    private static TreeNode helper(int left, int right) {
        if(left > right)
            return null;

        int rootVal = preOrder[preIndex];
        preIndex++;
        TreeNode root = new TreeNode(rootVal);
        int index = inOrderIndexMap.get(rootVal);

        root.left = helper(left, index - 1);
        root.right = helper(index + 1, right);

        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println();
    }
}
