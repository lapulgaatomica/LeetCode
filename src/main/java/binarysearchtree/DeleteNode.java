package binarysearchtree;

public class DeleteNode {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7)));
        TreeNode deleted = deleteNode(node, 3);
        System.out.println();
        TreeNode node1 = new TreeNode(0);
        TreeNode deleted1 = deleteNode(node1, 0);
        System.out.println();
    }

    private static TreeNode findSuccessor(TreeNode root) {
        TreeNode cur = root.right;
        while (cur != null && cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }
    public static TreeNode deleteNode(TreeNode root, int key) {
        // return null if root is null
        if (root == null) {
            return null;
        }

        // delete current node if root is the target node
        if (root.val == key) {
            // replace root with root->right if root->left is null
            if (root.left == null) {
                return root.right;
            }

            // replace root with root->left if root->right is null
            if (root.right == null) {
                return root.left;
            }

            // replace root with its successor if root has two children
            TreeNode p = findSuccessor(root);
            root.val = p.val;
            root.right = deleteNode(root.right, p.val);
            return root;
        }
        if (root.val < key) {
            // find target in right subtree if root->val < key
            root.right = deleteNode(root.right, key);
        } else {
            // find target in left subtree if root->val > key
            root.left = deleteNode(root.left, key);
        }
        return root;
    }
}
