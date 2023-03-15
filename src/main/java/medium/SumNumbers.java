package medium;

import treenode.TreeNode;

public class SumNumbers {
    public static void main(String[] args) {
//        System.out.println(sumNumbers(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
        System.out.println(sumNumbers(new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0))));
    }

    static int answer = 0;

    public static int sumNumbers(TreeNode root) {
        helper(root, 0);
        return answer;
    }

    private static void helper(TreeNode root, int multiplier) {
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            answer += (multiplier * 10) + root.val;
        }
        helper(root.left, (multiplier * 10) + root.val);
        helper(root.right, (multiplier * 10) + root.val);
    }
}
