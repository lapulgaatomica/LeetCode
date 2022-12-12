package binarysearchtree;

public class SearchBST {
    public static void main(String[] args) {

    }

    static TreeNode answer = null;

    public static TreeNode searchBST(TreeNode root, int val) {
        if(answer != null)
            return answer;
        if(root != null){
            if(root.val == val){
                answer = root;
                return answer;
            }
            if(root.val < val)
                return searchBST(root.right, val);
            else
                return searchBST(root.left, val);
        }
        return answer;
    }
}
