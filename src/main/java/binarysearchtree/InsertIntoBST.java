package binarysearchtree;

public class InsertIntoBST {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7));
        TreeNode inserted = insertIntoBST(treeNode, 5);
        System.out.println();
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode curr = root;

        while (curr != null && (curr.left != null || curr.right != null)){
            if(curr.val < val){
                if(curr.right != null)
                    curr = curr.right;
                else
                    break;
            } else{
                if(curr.left != null)
                    curr = curr.left;
                else
                    break;
            }
        }
        if(curr == null)
            return new TreeNode(val);
        else{
            if(curr.val < val)
                curr.right = new TreeNode(val);
            else
                curr.left = new TreeNode(val);
        }
        return root;
    }
}
