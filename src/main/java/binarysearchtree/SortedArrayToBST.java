package binarysearchtree;

import java.util.Arrays;

public class SortedArrayToBST {
    public static void main(String[] args) {
        TreeNode bst = sortedArrayToBST(new int[]{-10,-3,0,5,9});
        System.out.println();
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.right = sortedArrayToBST(Arrays.copyOfRange(nums, mid + 1, nums.length));
        root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, mid));

        return root;
    }
}
