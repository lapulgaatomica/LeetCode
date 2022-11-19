package trees.binary;

public class MaximumDepth {
    int answer = 0;
    public int maxDepth(TreeNode root) {
        recurseMaxDepth(root,  1);
        return answer;
    }

    private void recurseMaxDepth(TreeNode root, int depth) {
        if(root == null)
            return;
        if(root.right == null && root.left == null)
            answer = Math.max(answer, depth);

        recurseMaxDepth(root.left, depth + 1);
        recurseMaxDepth(root.right, depth + 1);
    }
}
