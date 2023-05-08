package medium;

import treenode.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ClosestValue {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(5));
        System.out.println(closestValue(treeNode, 3.714286));
    }

    static double closestValue = Double.MAX_VALUE;
    static int closestKey = Integer.MAX_VALUE;
    public static int closestValue(TreeNode root, double target) {
        helper(root, target);
        return closestKey;
    }

    private static void helper(TreeNode root, double target) {
        if(root == null)
            return;
        if(Math.abs(root.val - target) < closestValue){
            closestKey = root.val;
            closestValue = Math.abs(root.val - target);
        }

        helper(root.left, target);
        helper(root.right, target);
    }
}
