package trees.binary;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    public static void main(String[] args) {

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursiveTraversal(list, root);
        return list;
    }

    private static void recursiveTraversal(List<Integer> list, TreeNode root) {
        if(root == null)
            return;
        else{
            list.add(root.val);
            recursiveTraversal(list, root.left);
            recursiveTraversal(list, root.right);
        }
    }
}
