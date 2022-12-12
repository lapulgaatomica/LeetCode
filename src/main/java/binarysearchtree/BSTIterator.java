package binarysearchtree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    Queue<Integer> queue = new LinkedList<>();
    public BSTIterator(TreeNode root) {
        TreeNode curr = null;
        if(root != null){
            stack.push(root);
            curr = root;
        }

        while (!stack.empty()){
            curr = stack.pop();
            if(curr.left == null && curr.right == null){
                queue.offer(curr.val);
            }else{
                if(curr.right != null)
                    stack.push(curr.right);
                stack.push(new TreeNode(curr.val));
                if(curr.left != null)
                    stack.push(curr.left);
            }
        }
    }

    public int next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

class BSTIteratorTest{
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(7, new TreeNode(3), new TreeNode(15, new TreeNode(9), new TreeNode(20)));
        BSTIterator bstIterator = new BSTIterator(treeNode);
        System.out.println(bstIterator.next());    // return 3
        System.out.println(bstIterator.next());    // return 7
        System.out.println(bstIterator.hasNext()); // return True
        System.out.println(bstIterator.next());    // return 9
        System.out.println(bstIterator.hasNext()); // return True
        System.out.println(bstIterator.next());    // return 15
        System.out.println(bstIterator.hasNext()); // return True
        System.out.println(bstIterator.next());    // return 20
        System.out.println(bstIterator.hasNext()); // return False
    }
}
