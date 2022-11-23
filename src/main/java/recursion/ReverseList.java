package recursion;

import listnode.ListNode;

public class ReverseList {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(listNode);
        ListNode reversed = reverseList(listNode);
        System.out.println(reversed);
    }

    public static ListNode reverseList(ListNode head) {
        return reverseList(null, head);
    }

    private static ListNode reverseList(ListNode previous, ListNode head) {
        if(head == null)
            return previous;
        ListNode next = head.next;
        head.next = previous;
        previous = head;
        head = next;
        return reverseList(previous, head);
    }
}
