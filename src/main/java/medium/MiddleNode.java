package medium;

import listnode.ListNode;

public class MiddleNode {
    public static void main(String[] args) {

    }

    public static ListNode middleNode(ListNode head) {
        ListNode walk = head;
        int length = 0;
        while (walk != null){
            length++;
            walk = walk.next;
        }
        walk = head;
        int mid = length/2;
        int curr = 0;
        while (curr < mid){
            walk = walk.next;
            curr++;
        }
        return walk;
    }
}
