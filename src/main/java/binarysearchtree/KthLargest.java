package binarysearchtree;

public class KthLargest {
    private KthLargestTreeNode insertNode(KthLargestTreeNode root, int num) {
        if(root == null)
            return new KthLargestTreeNode(num, 1);
        if(root.val < num)
            root.right = insertNode(root.right, num);
        else
            root.left = insertNode(root.left, num);
        root.cnt++;
        return root;
    }
    KthLargestTreeNode root;
    int k;

    private int searchKth(KthLargestTreeNode root, int k) {
        // m = the size of right subtree
        int m = root.right != null ? root.right.cnt : 0;
        // root is the m+1 largest node in the BST
        if (k == m + 1) {
            return root.val;
        }
        if (k <= m) {
            // find kth largest in the right subtree
            return searchKth(root.right, k);
        } else {
            // find (k-m-1)th largest in the left subtree
            return searchKth(root.left, k - m - 1);
        }
    }

    public KthLargest(int k, int[] nums) {
        root = null;
        this.k = k;
        for(int num : nums)
            root = insertNode(root, num);
    }

    public int add(int val) {
        root = insertNode(root, val);
        return searchKth(root, k);
    }
}
class KthLargestTreeNode {
    int val;
    KthLargestTreeNode left;
    KthLargestTreeNode right;
    int cnt;

    KthLargestTreeNode() {}

    KthLargestTreeNode(int val, int cnt) {
        left = null;
        right = null;
        this.val = val;
        this.cnt = cnt;
    }
}

class Main{
    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[] {4, 5, 8, 2});
        System.out.println(kthLargest.add(3));   // return 4
        System.out.println(kthLargest.add(5));   // return 5
        System.out.println(kthLargest.add(10));  // return 5
        System.out.println(kthLargest.add(9));   // return 8
        System.out.println(kthLargest.add(4));   // return 8
    }
}