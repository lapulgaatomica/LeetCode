package recursion;

import treenode.TreeNode;

import java.util.ArrayDeque;

public class IsSameTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        TreeNode q = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        boolean check = isSameTree(p, q);
        System.out.println();
    }

    public static boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (q == null || p == null)
            return false;
        if (p.val != q.val)
            return false;

        return isSameTreeRecursive(p.left, q.left) && isSameTreeRecursive(p.right, q.right);
    }

    private static boolean check(TreeNode p, TreeNode q){
        if(p == null && q == null)
            return true;
        if(q == null || p == null)
            return false;
        return p.val == q.val;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null)
            return true;
        if(!check(p, q))
            return false;
        ArrayDeque<TreeNode> pDeque = new ArrayDeque<>();
        ArrayDeque<TreeNode> qDeque = new ArrayDeque<>();
        pDeque.addLast(p);
        qDeque.addLast(q);

        while (!pDeque.isEmpty()){
            p = pDeque.removeFirst();
            q = qDeque.removeFirst();

            if(!check(p, q))
                return false;

            if(!check(p.left, q.left))
                return false;
            if(p.left != null){
                pDeque.addLast(p.left);
                qDeque.addLast(q.left);
            }


            if(!check(p.right, q.right))
                return false;
            if(q.right != null){
                pDeque.addLast(p.right);
                qDeque.addLast(q.right);
            }
        }
        return true;
    }
}
