package unaccepted;

import treenode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsCompleteTree {
    public static void main(String[] args) {
        System.out.println(isCompleteTree(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), null))));
        System.out.println(isCompleteTree(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, null, new TreeNode(7)))));
        System.out.println(isCompleteTree(new TreeNode(1, new TreeNode(2, new TreeNode(5), null),
                new TreeNode(3, new TreeNode(7), new TreeNode(8)))));
    }

    public static boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean nullNodeFound = false;

        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            if(curr == null)
                nullNodeFound = true;
            else {
                if(nullNodeFound)
                    return false;
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        return true;
    }
}
