package trees;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursivePostorder(list, root);
        return list;
    }

    private void recursivePostorder(List<Integer> list, TreeNode root) {
        if(root == null)
            return;
        recursivePostorder(list, root.left);
        recursivePostorder(list, root.right);
        list.add(root.val);
    }
}
