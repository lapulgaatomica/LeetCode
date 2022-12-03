package recursion;

import treenode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(inorderTraversal(treeNode));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            answer.add(curr.val);
            curr = curr.right;
        }
        return answer;
    }
}
