package trees.binary;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursiveInorder(list, root);
        return list;
    }

    private void recursiveInorder(List<Integer> list, TreeNode root) {
        if(root == null)
            return;

        recursiveInorder(list, root.left);
        list.add(root.val);
        recursiveInorder(list, root.right);
    }


}
